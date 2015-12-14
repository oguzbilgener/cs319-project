package network;

import com.google.gson.Gson;
import model.GameSession;
import model.Piece;
import model.Player;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author oguzb
 */
public class P2PManager implements Observer {

    public static final int LISTEN_PORT = 4599;

    private Player ownPlayer;
    private Player otherPlayer;
    private P2PConnectionListener listener;
    private HostListen hostListen;
    private GuestConnect guestConnect;
    private Socket socket;
    private BufferedWriter socketOut;
    private BufferedReader socketIn;
    private boolean selfIsHost = false;

    private ConcurrentLinkedQueue<Message> messageQueue;

    public enum MessageType {
        CONNECT,
        DISCONNECT,
        REFUSED,
        IDENTIFY,
        WORD_CHOSEN,
        DRAW,
        DRAW_FINISH,
        WORD_GUESSED,
        GUESS_FAILED,
        NEXT_ROUND
    }

    public P2PManager(Player ownPlayer, P2PConnectionListener listener) {
        this.ownPlayer = ownPlayer;
        this.listener = listener;
        messageQueue = new ConcurrentLinkedQueue<>();
    }

    public void host() {
        selfIsHost = true;
        try {
            ServerSocket host = new ServerSocket(LISTEN_PORT);
            // Invoke a new thread to wait
            hostListen = new HostListen(host);
            hostListen.start();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    public void join(Player hostPlayer) {
        selfIsHost = false;
        if(socket == null)  {
            GuestConnect connect = new GuestConnect(hostPlayer);
            connect.start();
        }
    }

    public void close() {
        try {
            if(hostListen != null && hostListen.getHost() != null) {
                hostListen.getHost().close();
                hostListen = null;
            }
            if(guestConnect != null) {
                guestConnect = null;
            }
            if(socket != null) {
                socket.close();
                socket = null;
            }
            if(socketOut != null) {
                socketOut.close();
                socketOut = null;
            }
            if(socketIn != null) {
                socketIn.close();
                socketIn = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPiece(Piece piece) {
        sendMessage(new Message(MessageType.DRAW, piece));
    }

    public void finishDrawing() {
        sendMessage(new Message(MessageType.DRAW_FINISH));
    }

    public void failGuessing() {
        sendMessage(new Message(MessageType.GUESS_FAILED));
    }

    public void accomplishGuessing() {
        sendMessage(new Message(MessageType.WORD_GUESSED));
    }

    /**
     * Internal Interface
     */

    private void messageReceived(Message message, String jsonStr) {
        switch(message.getType()) {
            case CONNECT:
                connected((String) message.getContent());
                break;
            case DISCONNECT:
                disconnected();
                break;
            case REFUSED:
                refused();
                break;
            case IDENTIFY:
                if(selfIsHost) {
                    identified(jsonStr);
                }
                else {
                    identifyRequested(jsonStr);
                }
                break;
            case DRAW:
                pieceDrawn(message, jsonStr);
                break;
            case DRAW_FINISH:
                drawFinished();
                break;
            case WORD_CHOSEN:
                wordChosen(message);
                break;
            case WORD_GUESSED:
                guessAccomplished();
                break;
            case GUESS_FAILED:
                guessFailed();
                break;
            case NEXT_ROUND:
                beginNextRound();
                break;
        }
    }

    private void messageReceived(Message message) {
        messageReceived(message, null);
    }

    private void sendMessage(Message message) {
        messageQueue.add(message);
    }

    private void connected(String address) {
        System.out.println("Connected to "+address);
        if(listener != null) {
            listener.onConnected();
        }
        try {
            socketOut = new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't get output stream. closing socket");
            close();
        }
        // Start listening messages from the socket
        new MessageListen().start();
        new MessageSend().start();

        Timer timer = new Timer(1000, (e) -> {
            if(selfIsHost) {
                sendMessage(new Message(MessageType.IDENTIFY, ownPlayer));
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    private void disconnected() {
        System.out.println("disconnected!");
        if(listener != null) {
            listener.onDisconnected();
        }
    }

    private void refused() {
        System.out.println("refused!");
        if(listener != null) {
            listener.onHostConnectionRefused();
        }
    }

    private void identified(String jsonStr) {
        try {
            Player guest = Player.fromMessageJson(jsonStr);
            System.out.println("identified " + guest.getUsername());
            otherPlayer = guest;
            if(listener != null) {
                listener.onGuestIdentified(guest);
            }
        }
        catch(NullPointerException e) {
            System.out.println("identification failed!!");
        }
    }

    private void identifyRequested(String jsonStr) {
        System.out.println("identify requested");
        try {
            Player host = Player.fromMessageJson(jsonStr);
            System.out.println("found host: " + host.getUsername());
            otherPlayer = host;
            sendMessage(new Message(MessageType.IDENTIFY, ownPlayer));
        }
        catch(NullPointerException e) {
            System.out.println("identification failed!!");
        }
    }

    private void wordChosen(Message message) {
        if(listener != null) {
            listener.onWordChosen(message.content.toString());
        }
    }

    private void pieceDrawn(Message message, String jsonObject) {
        Piece piece = Piece.fromJson(jsonObject);
        System.out.println(piece.getPoints()==null);
        if(listener != null) {
            listener.onDraw(piece);
        }
    }

    private void drawFinished() {
        if(listener != null) {
            listener.onDrawFinished();
        }
    }

    private void guessFailed() {
        if(listener != null) {
            listener.onGuessingFinished();
        }
    }

    private void guessAccomplished() {
        if(listener != null) {
            listener.onGuessingFinished();
        }
    }

    private void beginNextRound() {
        if(listener != null) {
            listener.onNextRoundRequested();
        }
    }

    private class HostListen extends Thread {

        private ServerSocket host;

        public HostListen(ServerSocket host) {
            this.host = host;
        }

        @Override
        public void run() {
            super.run();
            try {
                // Busy-waiting
                setSocket(host.accept());
                // notify connected
                SwingUtilities.invokeLater(() -> messageReceived(new Message(MessageType.CONNECT, socket.getInetAddress().toString())));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public ServerSocket getHost() {
            return host;
        }
    }

    private class GuestConnect extends Thread {

        private Player hostPlayer;

        public GuestConnect(Player hostPlayer) {
            this.hostPlayer = hostPlayer;
        }

        @Override
        public void run() {
            super.run();
            int a = 0;
            // Try each of the available addresses
            while(socket == null && a < hostPlayer.getAddresses().length) {
                String address = hostPlayer.getAddresses()[a];
                try {
                    socket = new Socket();
                    socket.connect(new InetSocketAddress(address, LISTEN_PORT), 3000);
                } catch (SocketTimeoutException e) {
                    System.out.println("timed out while trying "+address);
                    socket = null;
                } catch (IOException e) {
                    System.out.println("IO exception while trying "+address);
                    socket = null;
                }
                a++;
            }
            if(socket != null) {
                // notify connected
                SwingUtilities.invokeLater(() ->
                    messageReceived(new Message(MessageType.CONNECT, socket.getInetAddress().toString()))
                );
            }
            else {
                // notify connection refused
                SwingUtilities.invokeLater(() ->
                    messageReceived(new Message(MessageType.REFUSED))
                );
            }
        }
    }

    private class MessageListen extends Thread {

        @Override
        public void run() {
            super.run();
            try {
                socketIn = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(socketIn != null) {
                try {
                    String line = socketIn.readLine();
                    while(line != null) {
                        System.out.println("received: "+line);
                        try {
                            Message m = new Gson().fromJson(line, Message.class);
                            final String l = line;
                            if(m != null) {
                                System.out.println("parseable! "+m.getType());
                                SwingUtilities.invokeLater(()->messageReceived(m, l));
                            }
                            else {
                                System.out.println("couldn't parse :(");
                            }
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                        line = socketIn.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    socketIn = null;
                    SwingUtilities.invokeLater(() -> messageReceived(new Message(MessageType.DISCONNECT)));
                }
            }
        }
    }

    private class MessageSend extends Thread {
        @Override
        public void run() {
            super.run();
            while(true) {
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {

                }
                while(!messageQueue.isEmpty()) {
                    Message message = messageQueue.poll();
                    try {
                        if (socket != null) {
                            System.out.println("Sending message: "+message.makeJson());
                            socketOut.write(message.makeJson()+"\n");
                            socketOut.flush();
                        } else {
                            throw new NullPointerException("Must be connected to a socket.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        if(observable instanceof GameSession) {
            if (data != null && data instanceof GameSession.Field) {
                GameSession.Field field = (GameSession.Field) data;
                if(field.name == GameSession.Field.Name.CHOSEN_WORD) {
                    // Tell other side that word is chosen
                    // So that they can show the related pane
                    if(selfIsHost) {
                        sendMessage(new Message(MessageType.WORD_CHOSEN, field.object));
                    }
                }
            }
        }
    }

    public Player getOwnPlayer() {
        return ownPlayer;
    }

    public Player getOtherPlayer() {
        return otherPlayer;
    }

    public boolean isSelfHost() {
        return selfIsHost;
    }

    private void setSocket(Socket socket) {
        this.socket = socket;
    }

    public interface P2PConnectionListener {
        void onConnected();
        void onGuestIdentified(Player guest);
        void onHostConnectionRefused();
        void onDisconnected();
        void onWordChosen(String word);
        void onDraw(Piece piece);
        void onDrawFinished();
        void onGuessingFinished();
        void onNextRoundRequested();
        void onError(Exception exception);
    }
}

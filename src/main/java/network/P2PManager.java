package network;

import com.google.gson.Gson;
import model.Player;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author oguzb
 */
public class P2PManager {

    public static final int LISTEN_PORT = 4599;

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

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
        GUESS_LETTER,
        WORD_GUESSED,
        TIMEOUT
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
                    identifyRequested();
                }
                break;
            case DRAW:
                break;
            case WORD_CHOSEN:
                break;
            case GUESS_LETTER:
                break;
            case WORD_GUESSED:
                break;
            case TIMEOUT:
                break;
        }
    }

    private void messageReceived(Message message) {
        messageReceived(message, null);
    }

    private void sendMessage(Message message) {
//        try {
//            if (socket != null) {
//                System.out.println("Sending message: "+message.makeJson()+" "+sdf.format(new Date()));
//                socketOut.write(message.makeJson());
//                socketOut.flush();
//                System.out.println("sent.");
//            } else {
//                throw new NullPointerException("Must be connected to a socket.");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        messageQueue.add(message);
    }

    public void connected(String address) {
        System.out.println("Connected to "+address+" "+sdf.format(new Date()));
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

        Timer timer = new Timer(3000, (e) -> {
            if(selfIsHost) {
                sendMessage(new Message(MessageType.IDENTIFY));
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    public void disconnected() {
        System.out.println("disconnected!");
        if(listener != null) {
            listener.onDisconnected();
        }
    }

    public void refused() {
        System.out.println("refused!");
        if(listener != null) {
            listener.onHostConnectionRefused();
        }
    }

    public void identified(String jsonStr) {
        try {
            Player guest = Player.fromMessageJson(jsonStr);
            System.out.println("identified " + guest.getUsername());
            otherPlayer = guest;
            if(listener != null) {
                listener.onGuestIdentified(guest);
            }
            sendMessage(new Message(MessageType.WORD_CHOSEN, "OGUZ"));
        }
        catch(NullPointerException e) {
            System.out.println("identification failed!!");
        }
    }

    public void identifyRequested() {
        System.out.println("identify requested");
        sendMessage(new Message(MessageType.IDENTIFY, ownPlayer));
    }

    public class HostListen extends Thread {

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

    public class GuestConnect extends Thread {

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

    public class MessageListen extends Thread {

        @Override
        public void run() {
            super.run();
            System.out.println("MessageListen invoke "+sdf.format(new Date()));
            try {
                socketIn = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            int x = 0;
            while(socketIn != null) {
                if(x == 0) {
                }
                try {
                    String line = socketIn.readLine();
                    while(line != null) {
                        System.out.println("received: "+line+" "+sdf.format(new Date()));
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
                            System.out.println("yo");
                            e.printStackTrace();
                        }
                        line = socketIn.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                x++;
                x %= 10000000;
            }
        }
    }

    public class MessageSend extends Thread {
        @Override
        public void run() {
            super.run();
            int x = 0;
            while(true) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while(!messageQueue.isEmpty()) {
                    Message message = messageQueue.poll();
                    try {
                        if (socket != null) {
                            System.out.println("Sending message: "+message.makeJson()+" "+sdf.format(new Date()));
                            socketOut.write(message.makeJson()+"\n");
                            socketOut.flush();
                            System.out.println("sent.");
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

    private void setSocket(Socket socket) {
        this.socket = socket;
    }

    public interface P2PConnectionListener {
        void onConnected();
        void onGuestIdentified(Player guest);
        void onHostConnectionRefused();
        void onDisconnected();
        void onError(Exception exception);
    }
}

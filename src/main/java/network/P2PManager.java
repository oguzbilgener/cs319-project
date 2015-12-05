package network;

import model.GameSession;
import model.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author oguzb
 */
public class P2PManager {

    public static final int LISTEN_PORT = 4599;

    private Socket socket;

    private GameSession session;

    public P2PManager(GameSession session) {

    }

    public void host(P2PConnectionListener connectionListener) {
        try {
            ServerSocket host = new ServerSocket(LISTEN_PORT);
            // Invoke a new thread to wait
            new HostWait(host, connectionListener).start();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    public class HostWait extends Thread {

        private ServerSocket host;
        private P2PConnectionListener listener;

        public HostWait(ServerSocket host, P2PConnectionListener listener) {
            this.host = host;
            this.listener = listener;
        }

        @Override
        public void run() {
            super.run();
            try {
                host.accept(); // Busy-waiting
                if(listener != null) {
                    listener.onGuestConnected(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
                if(listener != null) {
                    listener.onError(e);
                }
            }
        }
    }

    public interface P2PConnectionListener {
        void onGuestConnected(Player guest);
        void onError(Exception exception);
    }
}

package ro.uaic.info.georgeboghez;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * An instance of this class will create a ServerSocket running at a specified port. The server will receive requests (commands) from clients and it will execute them.
 */
public class GameServer {
    /**
     * the port on which the server is listening
     */
    public static final int PORT = 8100;

    /**
     * the constructor in which threads are created for handling the communication with the clients
     * @throws IOException
     */
    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket).run();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }
}

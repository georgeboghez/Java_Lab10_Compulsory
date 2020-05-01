package ro.uaic.info.georgeboghez;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * An instance of this class (class which extends Thread) will be responsible with communicating with a client Socket. If the server receives the command stop it will stop and will return to the client the respons "Server stopped", otherwise it return: "Command ... received".
 */
public class ClientThread extends Thread {
    /**
     * a Socket object representing an endpoint for communication between two machines.
     */
    private Socket socket;

    /**
     * Constructor which sets the socket correspondingly
     * @param socket a Socket object
     */
    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    /**
     * Get the request from the input stream: client → server
     * Send the response to the oputput stream: server → client
     */
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            System.out.println("Client named " + request + " connected.");
            String raspuns = "Hello, " + request + "!";
            out.println(raspuns);
            out.flush();

            boolean loop = true;
            while(loop) {
                request = in.readLine();
                System.out.println("Command '" + request + "' received.");
                if(request.equals("exit")){
                    loop = false;
                    raspuns = "Server Stopped";
                }
                else {
                    raspuns = "Response: command '" + request + "' received.";
                }
                out.println(raspuns);
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}

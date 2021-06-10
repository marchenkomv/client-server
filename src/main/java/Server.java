import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("New connection accepted.");
                System.out.println("Client IP: " + (((InetSocketAddress)clientSocket.getRemoteSocketAddress()).getAddress())
                        .toString()
                        .replace("/",""));
                System.out.println("Client port: " + clientSocket.getPort());
                System.out.println("Client message: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
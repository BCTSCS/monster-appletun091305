import java.net.*;
import java.io.*;
import java.util.*;

public class SimpleServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    public SimpleServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started and listening "+port);
        //out = serverSocket.getOutputStream();
        //in = serverSocket.getInputStream();
    }

    public void acceptClient() throws IOException {
        socket = serverSocket.accept();
        InputStream i = socket.getInputStream();
        OutputStream o = socket.getOutputStream();
        in = new Scanner(i);
        out = new PrintWriter(out);
    }

    public String receiveMessage() {
        return "";
    }

    public void sendMessage(String message) {
    }

    public void close() {
    }

    public static void main(String[] args) throws IOException {
        try {
            SimpleServer s = new SimpleServer(8888);
            s.acceptClient();
            while (true) {
                s.sendMessage("Hello ");
                String reply = s.receiveMessage();
                System.out.println(reply+" ");
                if (reply.equals("stop")) {break;}
            }
        } catch(Exception e) {
            System.out.println("Exception occured");
            e.printStackTrace();
        }
    }
}

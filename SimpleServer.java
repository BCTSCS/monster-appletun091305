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
        out = new PrintWriter(o);
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
            FileOperator file = new FileOperator("server.txt");
            while (true) {
                String user = s.receiveMessage();
                System.out.println("User: "+user);
                if (user.equals("exit")) {break;}
                
                String response = file.readLine();
                s.sendMessage(response);
                System.out.println("Us: "+response);
            }
        } catch(Exception e) {
            System.out.println("Exception occured");
            e.printStackTrace();
        }
    }
}

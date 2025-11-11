import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleClient {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;

    public SimpleClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        System.out.println("Client is connecting");
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new Scanner(socket.getInputStream());
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public String receiveMessage() { 
        return in.nextLine();
    }

    public void close() {
        out.close();
        in.close();
    }

    public static void main(String[] args) throws IOException {
        SimpleClient s = new SimpleClient("127.0.0.1", 8888);
        FileOperator file = new FileOperator("client.txt");
        while (true) {
            String message = file.readLine();
            s.sendMessage(message);
            if (message.equals("exit")) {break;}
            System.out.println("Me: "+message);

            String reply = s.receiveMessage();
            System.out.println("Server: "+reply);
        }
        s.close();
    }
}

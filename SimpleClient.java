import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleClient {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;

    public SimpleClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        System.out.println("Client is connecting");
    }

    public void sendMessage(String message) {
        
    }

    public String receiveMessage() { 
        return null; 
    }

    public void close() {

    }

    public static void main(String[] args) {

    }
}

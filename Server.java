// A Java program for a Serverside

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Server {
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // constructor with port
    public Server(int port) {
// starts server and waits for a connection
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");
// takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            String line = "";
// reads message from client until "Over" is sent
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(Integer.parseInt(line) * 2);


                } catch (IOException i) {
                    System.out.println(i);
                } catch (NumberFormatException n)
                {
                    System.out.println(n);
                    System.out.println("Please use proper number format without whitespaces!");
                }
            }
            System.out.println("Closing connection");
// close connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Please enter the server port!");
        Scanner sc = new Scanner(System.in);
        var portNumber = sc.nextInt();
        Server server = new Server(portNumber);
    }
}
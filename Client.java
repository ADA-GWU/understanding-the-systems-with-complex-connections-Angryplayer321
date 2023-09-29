// A Java program for a ClientSide

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // constructor to put ip address and port
    public Client(String address, int[] portNumbers) {
// establish a connection
        String line = "";
        while (true) {
            try {
                Random random = new Random();
                int serverNumber = random.nextInt(portNumbers.length);
                socket = new Socket(address, portNumbers[serverNumber]);
                System.out.println("Connected to Server " + serverNumber + "on port : " + portNumbers[serverNumber]);
// takes input from terminal
                input = new DataInputStream(System.in);
// sends output to the socket
                out = new DataOutputStream(socket.getOutputStream());
            } catch (UnknownHostException u) {
                System.out.println(u);
            } catch (IOException i) {
                System.out.println(i);
            }// string to read message from input

// keep reading until "Over" is input

            try {

                line = input.readLine();
                out.writeUTF(line);
                if (line.equals("Over")) {

                    break;
                }
            } catch (IOException i) {
                System.out.println(i);
            }
        }
// close the connection
try
{
input.close();
out.close();
socket.close();
}
catch(IOException i)
{
System.out.println(i);
}
}
public static void main(String args[]) {
    System.out.println("Please enter 1st, 2nd and 3rd servers' port numbers in according sequence!");
    Scanner sc = new Scanner(System.in);
    int[] portNumbers = new int[3];
    for (int i = 0; i < portNumbers.length; i++) {
        portNumbers[i] = sc.nextInt();
    }

    Client client = new Client("127.0.0.1", portNumbers);


}
}

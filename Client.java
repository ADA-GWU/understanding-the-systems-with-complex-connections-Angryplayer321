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


    // constructor to put ip address and port
    public Client(String address, int[] portNumbers) {
        // establish a connection
        String line = "";
        int serverNumber;
        Socket[] socket = new Socket[portNumbers.length];
        DataOutputStream[] out = new DataOutputStream[portNumbers.length];

        for (int i = 0; i < portNumbers.length; i++) {
            try {
                socket[i] = new Socket(address, portNumbers[i]);
                out[i] = new DataOutputStream(socket[i].getOutputStream());
            } catch (UnknownHostException u) {
                System.out.println(u);
            } catch (IOException io) {
                System.out.println(i);
            }
        }
        while (true) {
            Random random = new Random();
            serverNumber = random.nextInt(portNumbers.length);
            System.out.println("Connected to Server " + serverNumber + " on port : " + portNumbers[serverNumber] + "\nEnter the value!");
            // takes input from terminal
            input = new DataInputStream(System.in);
            // sends output to the socket
            try {

                line = input.readLine();
                if (line.equals("Over")) {

                    break;
                }
                out[serverNumber].writeUTF(line);

            } catch (IOException i) {
                System.out.println(i);
            }
        }
        // close the connection
        try {
            input.close();
            for (int i = 0; i < portNumbers.length; i++) {
                out[i].writeUTF("Over");
                out[i].close();
                socket[i].close();

            }

        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("Please enter 1st, 2nd and 3rd servers' port numbers in according sequence!\n Type \"Over\" in order to close the applications!");
        Scanner sc = new Scanner(System.in);
        int[] portNumbers = new int[3];
        for (int i = 0; i < portNumbers.length; i++) {
            portNumbers[i] = sc.nextInt();
        }



        Client client = new Client("127.0.0.1", portNumbers);


    }
}

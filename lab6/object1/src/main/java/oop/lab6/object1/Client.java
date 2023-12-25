package oop.lab6.object1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void send(String n, String min, String max) throws IOException {
        try (Socket socket = new Socket("localhost", 9092)) {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println(n);
            pw.println(min);
            pw.println(max);
            pw.close();
        }
    }
}

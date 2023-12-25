package oop.lab6.object2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Client {
    public static void send(List<AppController.DoubleData> vector) throws IOException {
        try (Socket socket = new Socket("localhost", 9091)) {
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            for (AppController.DoubleData doubleData : vector) {
                pw.println(doubleData.getValue());
                System.out.println(doubleData.getValue());
            }
            pw.close();
        }
    }
}

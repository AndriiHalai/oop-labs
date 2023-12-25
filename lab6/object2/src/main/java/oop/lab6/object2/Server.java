package oop.lab6.object2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static String receivedData;
    public static void start() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(9092)){
                while (true) {
                    Socket socket = serverSocket.accept();

                    try (InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
                         BufferedReader bufferedReader = new BufferedReader(inputStream)
                    ) {
                        Scanner scanner = new Scanner(inputStream);
                        int i = 0;
                        while (scanner.hasNext()) {
                            switch (i) {
                                case (0): AppController.n = Integer.parseInt(scanner.nextLine());
                                case (1): AppController.min = Double.parseDouble(scanner.nextLine());
                                case (2): AppController.max = Double.parseDouble(scanner.nextLine());
                            }
                            i++;
                        }
//                        String data = bufferedReader.readLine(); // Object?
//                        receivedData = data;
//                        System.out.println(data);
//                        inputStream.close();
                    }
                    AppController.generateVector();
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

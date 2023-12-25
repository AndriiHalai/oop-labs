package oop.lab6.object2;


import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void start() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(9092)){
                while (true) {
                    Socket socket = serverSocket.accept();

                    try (InputStreamReader inputStream = new InputStreamReader(socket.getInputStream())) {
                        Scanner scanner = new Scanner(inputStream);
                        String[] lines = new String[3];

                        for (int i = 0; i < 3 && scanner.hasNext(); i++) {
                            lines[i] = scanner.nextLine();
                        }

                        AppController.n = Integer.parseInt(lines[0]);
                        AppController.min = Double.parseDouble(lines[1]);
                        AppController.max = Double.parseDouble(lines[2]);
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

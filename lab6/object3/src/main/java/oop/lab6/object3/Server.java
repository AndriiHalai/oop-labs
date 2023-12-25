package oop.lab6.object3;

import javafx.application.Platform;
import javafx.scene.chart.XYChart;

import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static XYChart.Series<Number, Number> receivedData;
    public static void start() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(9091)){
                while (true) {
                    Socket socket = serverSocket.accept();
                    XYChart.Series<Number, Number> series = new XYChart.Series<>();

                    try (InputStreamReader inputStream = new InputStreamReader(socket.getInputStream())) {
                        Scanner scanner = new Scanner(inputStream);
                        int i = 0;
                        while (scanner.hasNext()) {
                            double y = Double.parseDouble(scanner.nextLine());
                            series.getData().add(new XYChart.Data<>(i, y));
                            i++;
                        }
                    }
                    receivedData = series;
                    Platform.runLater(() -> Object3Controller.draw(receivedData));
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

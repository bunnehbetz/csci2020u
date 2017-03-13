package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Main extends Application {
    int width = 700;
    int height = 500;
    int xStart = 50;

    @FXML
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception{

        WeatherCounter weather = new WeatherCounter();
        weather.fileProcess();

        Group root = new Group();
        Scene scene = new Scene(root, width, height);

        canvas = new Canvas();

        canvas.setWidth(width);
        canvas.setHeight(height);

        root.getChildren().add(canvas);
        primaryStage.setTitle("Lab 07");
        primaryStage.setScene(scene);
        primaryStage.show();

        draw(weather, root);
    }

    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    private void draw(WeatherCounter weather, Group group) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        drawLegend(weather, gc);

        xStart += 100;

        drawPieChart(weather, gc);
    }

    private void drawLegend(WeatherCounter weather, GraphicsContext gc){
        int size = weather.getSize();
        int yStart = 50;
        for (int i = 0; i < size; i++){
            gc.setFill(pieColours[i]);
            gc.setStroke(Color.BLACK);
            gc.fillRect(xStart, yStart, 20, 20);
            gc.strokeRect(xStart, yStart, 20, 20);
            yStart += 30;

            Font font = new Font("Arial", 8);
            gc.setFont(font);
            gc.setFill(Color.BLACK);
            gc.fillText(weather.keyWeather[i], (xStart + 25), (yStart - 10));
        }

        xStart += 100;
    }

    private void drawPieChart(WeatherCounter weather, GraphicsContext gc){
        int size = weather.getSize();
        double sAngle = 0.0;
        double total = (double)(weather.totalCount);
        for (int i = 0; i < size; i++){
            double dWeather = (double)(weather.keyCount[i]);
            double eAngle = (dWeather/total) * 360;
            gc.setFill(pieColours[i]);
            gc.setStroke(Color.BLACK);
            gc.strokeArc(xStart, 50, (height-100), (height-100), sAngle, eAngle, ArcType.ROUND);
            gc.fillArc(xStart, 50, (height-100), (height-100), sAngle, eAngle, ArcType.ROUND);
            sAngle += eAngle;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

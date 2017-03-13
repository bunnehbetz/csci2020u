package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {
    int width = 750;
    int height = 500;
    int xStart = 50;

    @FXML
    private Canvas canvas;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, width, height);

        canvas = new Canvas();

        canvas.setWidth(width);
        canvas.setHeight(height);

        root.getChildren().add(canvas);
        primaryStage.setTitle("Lab 06");
        primaryStage.setScene(scene);
        primaryStage.show();

        draw(root);

    }

    private static double[] avgHousingPricesByYear = {
            247381.0, 264171.4, 287715.3, 294736.1, 308431.4, 322635.9, 340253.0, 363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3, 1219479.5, 1246354.2, 1295364.8, 1335932.6, 1472362.0, 1583521.9, 1613246.3
    };

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    private void draw(Group group) {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        drawBarChart(gc);

        xStart += 50;

        drawPieChart(gc);
    }

    private void drawBarChart(GraphicsContext gc){
        double max;
        double maxHousing = getMax(avgHousingPricesByYear);
        double maxCommercial = getMax(avgCommercialPricesByYear);
        int numberBars = avgCommercialPricesByYear.length;

        if (maxHousing >= maxCommercial){
            max = maxHousing;
        }
        else {
            max = maxCommercial;
        }

        for (int i = 0; i < numberBars; i++){

            double dRedY = (avgHousingPricesByYear[i]/max)*(height-100);
            int redY = (int)dRedY;
            gc.setFill(Color.RED);
            gc.fillRect(xStart, (height-(redY+50)), 10, redY);

            xStart += 10;

            double dBlueY = (avgCommercialPricesByYear[i]/max)*(height-100);
            int blueY = (int)dBlueY;
            gc.setFill(Color.BLUE);
            gc.fillRect(xStart, (height-(blueY+50)), 10, blueY);

            xStart += 15;

        }

    }

    private void drawPieChart(GraphicsContext gc){
        double sAngle = 0.0;

        int numArcs = purchasesByAgeGroup.length;
        double purchaseTotal = (double)(purchaseTotal(purchasesByAgeGroup));

        for (int i = 0; i < numArcs; i++){
            System.out.print(i);
            gc.setFill(pieColours[i]);
            double dPurchase = (double)purchasesByAgeGroup[i];
            double eAngle = (dPurchase/purchaseTotal) * 360;
            gc.fillArc(xStart, 50, (height-100), (height-100), sAngle, eAngle, ArcType.ROUND);
            sAngle += eAngle;
        }

        System.out.print((xStart+height));
    }

    private double getMax(double[] array){
        int length = array.length;
        double max = 0;
        for (int i = 0; i < length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    private int purchaseTotal(int[] array){
        int length = array.length;
        int total = 0;
        for (int i = 0; i < length; i++){
            total += array[i];
        }
        return total;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

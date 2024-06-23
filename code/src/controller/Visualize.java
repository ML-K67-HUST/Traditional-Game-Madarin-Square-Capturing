package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Visualize extends Application {

    private static Integer[][] scores;

    @Override
    public void start(Stage stage) {
        visualize(stage, scores);
    }

    public static void visualize(Integer[][] data) {
        scores = data;
        launch();
    }

    private void visualize(Stage stage, Integer[][] scores) {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Player 2");
        xAxis.setTickLabelsVisible(false); // Hide x-axis tick labels
        xAxis.setTickMarkVisible(false);   // Hide x-axis tick marks

        NumberAxis yAxis = new NumberAxis(-100, 100, 10);
        yAxis.setLabel("");

        AreaChart<Number, Number> areaChart = new AreaChart<>(xAxis, yAxis);
        areaChart.setTitle("Player 1");

        XYChart.Series<Number, Number> seriesDifference = new XYChart.Series<>();
        seriesDifference.setName("Dominant Score");

        for (int i = 0; i < scores.length; i++) {
            double difference = scores[i][0] - scores[i][1];
            seriesDifference.getData().add(new XYChart.Data<>(i + 1, difference));
        }

        areaChart.getData().addAll(seriesDifference);

        String fontSizeStyle = "-fx-font-size: 16px;";
        areaChart.lookup(".chart-title").setStyle(fontSizeStyle);
        xAxis.lookup(".axis-label").setStyle(fontSizeStyle);

        Scene scene = new Scene(new StackPane(areaChart), 800, 600);
        stage.setScene(scene);
        stage.setTitle("Game Dominance Visualizer");
        stage.show();
    }

    public static void main(String[] args) {
        Integer[][] sampleScores = {
                {0, 0}, {7, 6}, {9, 7}, {17, 12}, {23, 18}, {28, 25}, {37, 31}, {44, 38},
                {48, 38}, {50, 43}, {58, 44}, {66, 45}, {75, 49}, {81, 52}, {89, 59},
                {97, 63}, {98, 72}, {100, 72}, {100, 76}, {100, 85}, {100, 90}, {100, 95},{95,100},{50,100}, {0,100},{20,100},{50,100},{51,100},{55,100},
                {30,100},{32,100},{20,100},{10,100},{0,100},{0,100},{0,100},{0,100},{0,100}, {13,90},{20,10},{30,10},{60,29},{13,50},{14,30},{20,67},{30,100},
                {40,50},{70,20},{90,0},{100,0},{100,0},{100,0},{100,0},{100,0}

        };

        visualize(sampleScores);
    }
}

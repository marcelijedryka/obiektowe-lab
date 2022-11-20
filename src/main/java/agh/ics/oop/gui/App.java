package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import static java.lang.System.out;

public class App  extends Application {

    private AbstractWorldMap map;


    @Override
    public void init() throws Exception {
//        String[] ruchy = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        String[] moves = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(moves);
        map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
//        out.println(map);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = drawGrid();
        Scene scene = new Scene(grid, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane drawGrid() {
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        Label beginning = new Label("y/x");
        grid.add(beginning, 0, 0);
        GridPane.setHalignment(beginning, HPos.CENTER);
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(30));

        Vector2d lowLeft = map.searchLowLeft();
        Vector2d upRight = map.searchUpRight();

        for (int i = 1; i < upRight.x - lowLeft.x + 2; i++) {
            String field = Integer.toString(lowLeft.x + i - 1);
            Label current = new Label(field);
            grid.add(current, i, 0);
            GridPane.setHalignment(current, HPos.CENTER);
            grid.getColumnConstraints().add(new ColumnConstraints(30));
        }

        for (int i = 1; i < upRight.y - lowLeft.y + 2; i++) {
            String field = Integer.toString(upRight.y - i + 1);
            Label current = new Label(field);
            grid.add(current, 0, i);
            GridPane.setHalignment(current, HPos.CENTER);
            grid.getRowConstraints().add(new RowConstraints(30));
        }


//        Próba implementacji z użyciem iteracji po mapie ( problem ze znalezieniem odpowiednich indeksów)
//        for (Vector2d key : map.getMap().keySet()) {
//            Object taken = map.objectAt(key);
//            Label place_object = new Label(taken.toString());
//            if (lowLeft.x == 0) {
//                grid.add(place_object, key.x + 1, upRight.y - key.y + 1);
//                GridPane.setHalignment(place_object, HPos.CENTER);
//            } else {
//                grid.add(place_object, key.x+1, upRight.y - key.y +1);}
//                GridPane.setHalignment(place_object, HPos.CENTER);
//            }

        for (int i = 1; i < upRight.x - lowLeft.x + 2; i++) {
            for (int j = 1; j < upRight.y - lowLeft.y + 2; j++) {
                Vector2d current_field = new Vector2d(lowLeft.x + i -1 , upRight.y-j + 1);
                if (map.isOccupied(current_field)){
                    Object object = map.objectAt(current_field);
                    Label current_label = new Label(object.toString());
                    grid.add(current_label ,i ,j);
                    GridPane.setHalignment(current_label, HPos.CENTER);

                }
            }
        }

        return grid;
    }
}

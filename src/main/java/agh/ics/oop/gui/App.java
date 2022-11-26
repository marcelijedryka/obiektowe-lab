package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;

public class App  extends Application implements IAppObserver {

    private AbstractWorldMap map;

    private GridPane grid;

    private SimulationEngine engine;

    private  Thread engineThread;
    @Override
    public void init() throws Exception {
        String[] moves = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(moves);
        map = new GrassField(10);
        ((GrassField) map).addObserver(this);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        engine = new SimulationEngine(directions, map, positions , 300);
        simulationStart(moves);
    }

    public void simulationStart(String[] sequence){
        MoveDirection[] directions = new OptionsParser().parse(sequence);
        engine.setDirection(directions);
        engineThread = new Thread(engine);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        grid = new GridPane();
        drawGrid(grid);
        VBox box = new VBox();
        TextField text = new TextField();
        Button button =new Button("Start");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String moves = text.getText();
                simulationStart(moves.split(" "));
                drawGrid(grid);
                engineThread.start();
            }
        });
        box.getChildren().addAll(text ,button , grid);
        Scene scene = new Scene(box, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GrassField");
        primaryStage.getIcons().add(new Image(new FileInputStream("src/main/resources/zwierzak_south.png")));
        primaryStage.show();
    }

    public void drawGrid(GridPane grid) {

        grid.setGridLinesVisible(false);
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();
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
            grid.getColumnConstraints().add(new ColumnConstraints(40));
        }

        for (int i = 1; i < upRight.y - lowLeft.y + 2; i++) {
            String field = Integer.toString(upRight.y - i + 1);
            Label current = new Label(field);
            grid.add(current, 0, i);
            GridPane.setHalignment(current, HPos.CENTER);
            grid.getRowConstraints().add(new RowConstraints(40));
        }


        for (int i = 1; i < upRight.x - lowLeft.x + 2; i++) {
            for (int j = 1; j < upRight.y - lowLeft.y + 2; j++) {
                Vector2d current_field = new Vector2d(lowLeft.x + i -1 , upRight.y-j + 1);
                if (map.isOccupied(current_field)){
                    GuiElementBox image = new GuiElementBox(map.objectAt(current_field) ,grid , i ,j);
                }
            }
        }

    }

    @Override
    public void positionChanged() {
        Platform.runLater(() -> {
            drawGrid(grid);
        });
    }
}

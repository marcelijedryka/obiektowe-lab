package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.Grass;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GuiElementBox {
    public GuiElementBox(Object object ,GridPane grid ,int y , int x){

        String desc;
        ImageView image;
        if (object instanceof Animal){
            image = ((Animal) object).getImage();
            desc = "A " + ((Animal) object).getCurrent_position().toString();
        }
        else {
            image = ((Grass) object).getImage();
            desc = "Grass";
        }
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(image, new Label(desc));
        grid.add(box ,y , x);
        GridPane.setHalignment(image, HPos.CENTER);
    }
}

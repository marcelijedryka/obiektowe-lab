package agh.ics.oop;
import javafx.scene.image.ImageView;



public class Grass extends AbstractImageGetter {
    private final Vector2d position;
    public Grass(Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return "*";
    }

    @Override
    public ImageView getImage() {

        ImageView image = getGrass();
        image.setFitWidth(20);
        image.setFitHeight(20);
        return image;
    }

}

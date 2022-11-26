package agh.ics.oop;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public abstract class AbstractImageGetter implements IMapElement {

    private ImageView aNorth;
    private ImageView aSouth;
    private ImageView aEast;
    private ImageView aWest;
    private ImageView grass;


    public AbstractImageGetter(){
        try{
        aNorth =  new ImageView(new Image(new FileInputStream("src/main/resources/zwierzak_north.png")));
        aSouth =   new ImageView(new Image(new FileInputStream("src/main/resources/zwierzak_south.png")));
        aEast =  new ImageView(new Image(new FileInputStream("src/main/resources/zwierzak_east.png")));
        aWest =  new ImageView(new Image(new FileInputStream("src/main/resources/zwierzak_west.png")));
        grass =  new ImageView(new Image(new FileInputStream("src/main/resources/grass.png")));
        }catch (FileNotFoundException exception){
            System.out.println(exception);
        }
    }

    public abstract ImageView getImage() ;

    public ImageView getaNorth() {
        return aNorth;
    }

    public ImageView getaSouth() {
        return aSouth;
    }

    public ImageView getaEast() {
        return aEast;
    }

    public ImageView getaWest() {
        return aWest;
    }

    public ImageView getGrass() {
        return grass;
    }
}

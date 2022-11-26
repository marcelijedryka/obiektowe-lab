package agh.ics.oop;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Animal extends AbstractImageGetter  {
    private Vector2d current_position;
    private MapDirection current_orientation;
    private ArrayList<IPositionChangeObserver> ObserverList;
    private final IWorldMap map;

    public Animal(IWorldMap map) {
        this.map = map;
        this.current_position = new Vector2d(2, 2);
        this.current_orientation = MapDirection.NORTH;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.current_position = initialPosition;
        this.current_orientation = MapDirection.NORTH;
        this.ObserverList = new ArrayList<>();
        IPositionChangeObserver observer = (IPositionChangeObserver) map;
        addObserver(observer);

    }


    void addObserver(IPositionChangeObserver observer) {
        ObserverList.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        ObserverList.remove(observer);
    }

    public void positionChange(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : ObserverList) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public Vector2d getCurrent_position() {
        return current_position;
    }

    public MapDirection getCurrent_orientation() {
        return current_orientation;
    }


    public String toString() {
        return switch (current_orientation) {
            case WEST -> "W";
            case SOUTH -> "S";
            case EAST -> "E";
            case NORTH -> "N";
        };
    }

    public boolean isAt(Vector2d position) {
        return current_position.equals(position);
    }

    void move(MoveDirection direction) {
        Vector2d changed_position = new Vector2d(current_position.x, current_position.y);
        MapDirection new_orientation = current_orientation;
        switch (direction) {
            case RIGHT -> new_orientation = this.current_orientation.next();
            case LEFT -> new_orientation = this.current_orientation.previous();
            case FORWARD -> changed_position = this.current_position.add(this.current_orientation.toUnitVector());
            case BACKWARD -> changed_position = this.current_position.substract(this.current_orientation.toUnitVector());
        }
        if (!new_orientation.equals(current_orientation)){
            current_orientation = new_orientation;
            ((GrassField) map).updateObserver();

        }
        if (map.canMoveTo(changed_position)) {
            Vector2d old_position = current_position;
            this.current_position = changed_position;
            positionChange(old_position, changed_position);
        }
    }

    @Override
    public ImageView getImage() {
        ImageView image = null;
        switch (this.current_orientation) {
            case NORTH -> image = getaNorth();
            case SOUTH -> image = getaSouth();
            case WEST ->  image =  getaWest();
            case EAST -> image =  getaEast();
        }

        image.setFitWidth(20);
        image.setFitHeight(20);
        return image;
    }


}



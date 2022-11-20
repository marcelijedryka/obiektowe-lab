package agh.ics.oop;
public abstract class AbstractWorldMap implements IWorldMap , IPositionChangeObserver {

    public abstract boolean canMoveTo(Vector2d position) ;


    public abstract boolean place(Animal animal) ;


    public abstract boolean isOccupied(Vector2d position) ;


    public abstract Object objectAt(Vector2d position) ;

    public String toString() {
        MapVisualizer draw = new MapVisualizer(this);
        return draw.draw(searchLowLeft(),searchUpRight());
    }

    public abstract Vector2d searchLowLeft();

    public abstract Vector2d searchUpRight();

    public abstract void positionChanged(Vector2d oldPosition, Vector2d newPosition);

}

package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    SortedSet<Vector2d> xArray;
    SortedSet<Vector2d> yArray;

    public MapBoundary(){
        xArray = new TreeSet<Vector2d>(new CompareValue("x"));
        yArray = new TreeSet<Vector2d>(new CompareValue("y"));
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeFromBoundry(oldPosition);
        addToBoundry(newPosition);
    }

    public void addToBoundry(Vector2d position){
        xArray.add(position);
        yArray.add(position);
    }

    public void removeFromBoundry(Vector2d position){
        xArray.remove(position);
        yArray.remove(position);
    }

    public Vector2d upperRight(){
        return new Vector2d(xArray.last().x, yArray.last().y);
    }

    public Vector2d lowerLeft(){
        return new Vector2d(xArray.first().x , yArray.first().y);
    }

}

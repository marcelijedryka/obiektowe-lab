package agh.ics.oop;
import java.util.*;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {

    private final Map<Vector2d , Object> map = new HashMap<>();
    private final int amount;

    private IAppObserver observer;

    private final MapBoundary boundary;
    public GrassField(int n) {
        amount =n;
        Random roll = new Random();
        boundary = new MapBoundary();

        while (map.size() < amount){
            Vector2d position = new Vector2d(roll.nextInt((int) Math.sqrt(amount * 10)), roll.nextInt((int) Math.sqrt(amount * 10)));
            if (!isOccupied(position)){
                map.put(position , new Grass(position));
                boundary.addToBoundry(position);
            }
        }

    }

    public Map<Vector2d, Object> getMap() {
        return map;
    }

    public void generateNewGrass(Grass grass){
        map.remove(grass.getPosition());
        boundary.removeFromBoundry(grass.getPosition());
        Random roll =new Random();
        boolean flag = true;
        while (flag){
            Vector2d position = new Vector2d(roll.nextInt((int) Math.sqrt(amount * 10)), roll.nextInt((int) Math.sqrt(amount * 10)));
            if (!isOccupied(position)) {
               map.put(position , new Grass(position));
               boundary.addToBoundry(position);
               flag =false;
            }
        }

    }

    public boolean canMoveTo(Vector2d position) {
        if (map.containsKey(position)){
            if (map.get(position) instanceof Grass){
                generateNewGrass((Grass) map.get(position));
                return true;
            }
            //po
            return false;
        }
        return true;
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getCurrent_position())){
            map.put(animal.getCurrent_position() , animal);
            boundary.addToBoundry(animal.getCurrent_position());
            animal.addObserver(boundary);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
            return map.containsKey(position);
        }

    public Object objectAt(Vector2d position) {
        if (isOccupied(position)){
            return map.get(position);
        }
        return null;
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = (Animal) map.get(oldPosition);
        map.remove(oldPosition);
        map.put(newPosition ,animal);
        observer.positionChanged();
    }

    public Vector2d searchLowLeft(){

        return boundary.lowerLeft();
    }

    public Vector2d searchUpRight(){

        return boundary.upperRight();
}

    public void updateObserver(){
        observer.positionChanged();
    }
    public void addObserver(IAppObserver application){
        observer = application;
    }


}

package agh.ics.oop;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
public class GrassField extends AbstractWorldMap {

    private final ArrayList<Grass> grassPos;
    private final ArrayList<Animal> animalPos;
    private final int amount;
    public GrassField(int n) {
        animalPos = new ArrayList<Animal>();
        grassPos = new ArrayList<Grass>();
        amount =n;
        Random roll = new Random();
        while (grassPos.size() < amount){
            Vector2d position = new Vector2d(roll.nextInt((int) Math.sqrt(amount * 10)), roll.nextInt((int) Math.sqrt(amount * 10)));
            if (!isOccupied(position)) {
                grassPos.add(new Grass(position));
            }
        }
    }

    public ArrayList<Grass> getGrassPos() {
        return grassPos;
    }

    public ArrayList<Animal> getAnimalPos() {
        return animalPos;
    }

    public void generateNewGrass(Grass grass){
        grassPos.remove(grass);
        Random roll = new Random();
        while (grassPos.size() < amount){
            Vector2d position = new Vector2d(roll.nextInt((int) Math.sqrt(amount * 10)), roll.nextInt((int) Math.sqrt(amount * 10)));
            if (!isOccupied(position)) {
                grassPos.add(new Grass(position));
            }
        }

    }

    public boolean canMoveTo(Vector2d position) {
        //implementacja zadania 12
        for (Grass grass : grassPos){
            if (grass.getPosition().equals(position)){
                generateNewGrass(grass);
                return true;
            }
        }
        for (Animal animal : animalPos) {
            if (animal.getCurrent_position().equals(position)) {
                return false;
            }
        }
        return true;
    }

    public boolean place(Animal animal) {
        for (Animal pos_animal : animalPos) {
            if (pos_animal.getCurrent_position().equals(animal.getCurrent_position())) {
                return false;
            }
        }
        animalPos.add(animal);
        return true;
    }

    public boolean isOccupied(Vector2d position) {
        for (Grass grass : grassPos) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        for (Animal animal : animalPos) {
            if (animal.getCurrent_position().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animalPos) {
            if (animal.getCurrent_position().equals(position)) {
                return animal;
            }
        }
        for (Grass grass : grassPos) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }
    public void repositionAnimal(Vector2d current_position, Vector2d changed, Animal animal){}

    public Vector2d searchLowLeft(){
        int minX = animalPos.get(0).getCurrent_position().x;
        int minY = animalPos.get(0).getCurrent_position().y;
        for (Animal animal : animalPos) {
            if (animal.getCurrent_position().x < minX) {
                minX = animal.getCurrent_position().x;
            }
            if (animal.getCurrent_position().y < minY) {
                minY = animal.getCurrent_position().y;
            }
        }
        for (Grass grass : grassPos){
            if (grass.getPosition().x < minX){
                minX = grass.getPosition().x;
            }
            if (grass.getPosition().y < minY){
                minY = grass.getPosition().y;
            }
        }
        return new Vector2d(minX , minY);
    }

    public Vector2d searchUpRight(){
        int maxX = animalPos.get(0).getCurrent_position().x;
        int maxY = animalPos.get(0).getCurrent_position().y;
        for (Animal animal : animalPos) {
            if (animal.getCurrent_position().x > maxX) {
                maxX = animal.getCurrent_position().x;
            }
            if (animal.getCurrent_position().y > maxY) {
                maxY = animal.getCurrent_position().y;
            }
        }
        for (Grass grass : grassPos){
            if (grass.getPosition().x > maxX){
                maxX= grass.getPosition().x;
            }
            if (grass.getPosition().y > maxY){
                maxY = grass.getPosition().y;
            }
        }
        return new Vector2d(maxX , maxY);
    }
}

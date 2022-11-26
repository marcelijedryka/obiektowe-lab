package agh.ics.oop;
import java.util.ArrayList;
public class SimulationEngine implements IEngine , Runnable {

    private MoveDirection[] moves;
    private final ArrayList<Animal> animals;

    private final int moveDelay;


    public SimulationEngine(MoveDirection[] moves , IWorldMap map , Vector2d[] starting_positions , int moveDelay) {
        this.moves=moves;
       this.moveDelay = moveDelay;
       animals = new ArrayList<Animal>();
       for(Vector2d pos : starting_positions){
           Animal possible_animal = new Animal(map,pos);
           if (map.place(possible_animal)){
               animals.add(possible_animal);

           }else {
               throw new IllegalArgumentException("Animal can not be placed on field " + possible_animal.getCurrent_position());
           }
       }

    }

    public void setDirection(MoveDirection[] moves){
        this.moves = moves;
    }
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void run() {
        int j= 0;
        for (MoveDirection move : moves) {
            try {
                Thread.sleep(moveDelay);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            if (j == animals.size()) {
                j = 0;
            }
            animals.get(j).move(move);
            j++;

        }
    }


}

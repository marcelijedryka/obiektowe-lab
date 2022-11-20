package agh.ics.oop;
import java.util.ArrayList;

public class SimulationEngine implements IEngine {

    private final MoveDirection[] moves;
    private final IWorldMap map;
    private final ArrayList<Animal> animals;

    public SimulationEngine(MoveDirection[] moves , IWorldMap map , Vector2d[] starting_positions) {
       this.map=map;
       this.moves=moves;
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

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void run() {
        int j= 0;
        for(int i=0 ; i < moves.length ; i++){
            if(j == animals.size()){
                j=0;
            }
            animals.get(j).move(moves[i]);
//            System.out.println(map);
            j++;
        }
    }
}

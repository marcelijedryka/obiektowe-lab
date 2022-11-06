package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrassFieldTest {

    @Test
    public void check_grassfield_test(){
        String[] ruchy = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(ruchy);
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        //test sprawdzający czy na mapie znajduje się poprawna ilość trawy
        assertEquals(10 , map.getGrassPos().size());

        //test sprawdzający czy na mapie znajduje sie poprawna ilość zwierząt
        assertEquals(2,map.getAnimalPos().size());

        /*test sprawdzający poprawność końcowych pozycji zwierząt na mapie, a co za tym idzie
        poprawność metod zaimplementowanych w klasie GrassField dziedziczącej z klasy
        AbstractWorldMap*/
        assertEquals(new Vector2d(3,7) , engine.getAnimals().get(1).getCurrent_position());
        assertEquals(new Vector2d(2,-1) , engine.getAnimals().get(0).getCurrent_position());

    }
}

package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class RectangularMapTest {

    @Test
    public void checkRectangularMapTest(){
        //końcowe pozycje zwierząt są poprawne a zatem metody w klasie
        //RectangularMap, która dziedziczy z klasy AbstractWorldMap są zaimplementowane poprawnie
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        String[] moves = new String[] {"f" ,"b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(moves);
        SimulationEngine engine = new SimulationEngine(directions, map, positions ,1);
        engine.run();
        assertEquals(new Vector2d(3,4) , engine.getAnimals().get(1).getCurrent_position());
        assertEquals(new Vector2d(2,0) , engine.getAnimals().get(0).getCurrent_position());
    }


}

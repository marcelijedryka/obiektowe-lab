package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {

    @Test
    public void orientationtest() {
        Animal testanimal = new Animal();
        assertEquals("(2,2) Północ", testanimal.toString());
        testanimal.move(MoveDirection.RIGHT);
        assertEquals("(2,2) Wschód", testanimal.toString());
        testanimal.move(MoveDirection.LEFT);
        assertEquals("(2,2) Północ", testanimal.toString());
    }

    @Test
    public void positiontest() {
        Animal testanimal = new Animal();
        testanimal.move(MoveDirection.FORWARD);
        assertEquals("(2,3) Północ", testanimal.toString());
        testanimal.move(MoveDirection.RIGHT);
        testanimal.move(MoveDirection.FORWARD);
        assertEquals("(3,3) Wschód", testanimal.toString());
        testanimal.move(MoveDirection.LEFT);
        testanimal.move(MoveDirection.BACKWARD);
        assertEquals("(3,2) Północ", testanimal.toString());
    }

    @Test
    public void outofmaptest() {
        Animal testanimal1 = new Animal();
        testanimal1.move(MoveDirection.FORWARD);
        testanimal1.move(MoveDirection.FORWARD);
        testanimal1.move(MoveDirection.FORWARD);
        assertEquals("(2,4) Północ", testanimal1.toString());
        Animal testanimal2 = new Animal();
        testanimal2.move(MoveDirection.BACKWARD);
        testanimal2.move(MoveDirection.BACKWARD);
        testanimal2.move(MoveDirection.BACKWARD);
        assertEquals("(2,0) Północ", testanimal2.toString());
        Animal testanimal3 = new Animal();
        testanimal3.move(MoveDirection.LEFT);
        testanimal3.move(MoveDirection.FORWARD);
        testanimal3.move(MoveDirection.FORWARD);
        testanimal3.move(MoveDirection.FORWARD);
        assertEquals("(0,2) Zachód", testanimal3.toString());
        Animal testanimal4 = new Animal();
        testanimal4.move(MoveDirection.RIGHT);
        testanimal4.move(MoveDirection.FORWARD);
        testanimal4.move(MoveDirection.FORWARD);
        testanimal4.move(MoveDirection.FORWARD);
        assertEquals("(4,2) Wschód", testanimal4.toString());
    }

    @Test
    public void interpretationtest() {

        MoveDirection[] correct = {MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD};
        String[] test1 = {"r", "l", "f", "b"};
        String[] test2 = {"right", "left", "forward", "backward"};
        String[] test3 = {"r", "w", "left", "g", "f", "backward"};
        MoveDirection[] test1a = parse(test1);
        MoveDirection[] test2a = parse(test2);
        MoveDirection[] test3a = parse(test3);
        for (int i = 0; i < 4; i++) {
            assertEquals(correct[i], test1a[i]);
            assertEquals(correct[i], test2a[i]);
            assertEquals(correct[i], test3a[i]);
        }
    }
}

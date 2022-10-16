package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MapDirectionTest {
    @Test
    public void testnext(){
        assertEquals(MapDirection.NORTH , MapDirection.WEST.next());
        assertEquals(MapDirection.EAST , MapDirection.NORTH.next());
        assertEquals(MapDirection.SOUTH , MapDirection.EAST.next());
        assertEquals(MapDirection.WEST , MapDirection.SOUTH.next());
    }

    @Test
    public void testprevious(){
        assertEquals(MapDirection.NORTH , MapDirection.EAST.previous());
        assertEquals(MapDirection.EAST , MapDirection.SOUTH.previous());
        assertEquals(MapDirection.SOUTH , MapDirection.WEST.previous());
        assertEquals(MapDirection.WEST , MapDirection.NORTH.previous());
    }
}


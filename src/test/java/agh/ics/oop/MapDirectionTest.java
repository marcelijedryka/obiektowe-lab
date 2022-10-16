package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static agh.ics.oop.Vector2d.*;
import static agh.ics.oop.MapDirection.*;

public class MapDirectionTest {
    @Test
    public void testnext(){
        assertEquals(MapDirect.NORTH , MapDirect.WEST.next());
        assertEquals(MapDirect.EAST , MapDirect.NORTH.next());
        assertEquals(MapDirect.SOUTH , MapDirect.EAST.next());
        assertEquals(MapDirect.WEST , MapDirect.SOUTH.next());
    }

    @Test
    public void testprevious(){
        assertEquals(MapDirect.NORTH , MapDirect.EAST.previous());
        assertEquals(MapDirect.EAST , MapDirect.SOUTH.previous());
        assertEquals(MapDirect.SOUTH , MapDirect.WEST.previous());
        assertEquals(MapDirect.WEST , MapDirect.NORTH.previous());
    }
}

class Vector2dTest{
    @Test
    public void testequals(){
        Vector2d testv1 = new Vector2d(1,2);
        Vector2d testv2 = new Vector2d(1,2);
        Object other = new Object();
        assertTrue(testv1.equals(testv2));
        assertFalse(testv1.equals(other));
    }

    @Test
    public void testtoString(){
        Vector2d testvector = new Vector2d(1,2);
        assertEquals("(1,2)" , testvector.toString());
    }

    @Test
    public void testprecedes(){
        Vector2d testv1 = new Vector2d(1 , 1);
        Vector2d testv2 = new Vector2d(2 , 2);
        assertTrue(testv1.precedes(testv2));
        assertFalse(testv2.precedes(testv1));
    }

    @Test
    public void testfollows(){
        Vector2d testv1 = new Vector2d(1 , 1);
        Vector2d testv2 = new Vector2d(2 , 2);
        assertFalse(testv1.follows(testv2));
        assertTrue(testv2.follows(testv1));
    }

    @Test
    public void testupperRight(){
        Vector2d testv1 = new Vector2d(-1,7);
        Vector2d testv2 = new Vector2d(3,2);
        Vector2d answer = new Vector2d(3,7);
        assertEquals(answer , testv1.upperRight(testv2));
    }

    @Test
    public void testlowerLeft(){
        Vector2d testv1 = new Vector2d(-1,7);
        Vector2d testv2 = new Vector2d(3,2);
        Vector2d answer = new Vector2d(-1,2);
        assertEquals(answer , testv1.lowerLeft(testv2));
    }

    @Test
    public void testadd(){
        Vector2d testv1 = new Vector2d(-1,7);
        Vector2d testv2 = new Vector2d(3,2);
        Vector2d answer = new Vector2d(2,9);
        assertEquals(answer , testv1.add(testv2));
    }

    @Test
    public void testsubtract(){
        Vector2d testv1 = new Vector2d(-1,7);
        Vector2d testv2 = new Vector2d(3,2);
        Vector2d answer = new Vector2d(-4 , 5);
        Vector2d answer2 = new Vector2d(4 , -5);
        assertEquals(answer , testv1.substract(testv2));
        assertEquals(answer2 , testv2.substract(testv1));
    }
    @Test
    public void testopposite() {
        Vector2d testv = new Vector2d(-1, 7);
        Vector2d answer = new Vector2d(1, -7);
        assertEquals(answer, testv.opposite());
    }


}
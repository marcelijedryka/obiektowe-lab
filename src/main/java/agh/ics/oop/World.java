package agh.ics.oop;

import static agh.ics.oop.Direction.ChoosePath;
import static java.lang.System.out;

class Vector2d {
    final public int x;
    final public int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        String a = String.format("%d" ,this.x);
        String b = String.format("%d" ,this.y);
        return "(" + a + "," + b + ")";
    }
    public boolean precedes(Vector2d other){
        if (this.x <= other.x && this.y <= other.y)
            return true;
        return false;
    }
    public boolean follows(Vector2d other){
        if (this.x >= other.x && this.y >= other.y)
            return true;
        return false;
    }
    public Vector2d upperRight(Vector2d other){
        int a = (this.x >= other.x) ? this.x : other.x;
        int b = (this.y >= other.y) ? this.y : other.y;
        Vector2d upright = new Vector2d(a,b);
        return upright;
    }

    public Vector2d lowerLeft(Vector2d other){
        int a = (this.x <= other.x) ? this.x : other.x;
        int b = (this.y <= other.y) ? this.y : other.y;
        Vector2d loleft = new Vector2d(a,b);
        return loleft;
    }

    public Vector2d add(Vector2d other){
        int a = this.x + other.x;
        int b = this.y + other.y;
        Vector2d summed = new Vector2d(a,b);
        return summed;
    }
    public Vector2d substract(Vector2d other){
        int a = this.x - other.x;
        int b = this.y - other.y;
        Vector2d subtracted = new Vector2d(a,b);
        return subtracted;
    }
    public boolean equals(Object other){
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if ( this.x == that.x && this.y==that.y)
            return true;
        return false;
    }

    public Vector2d opposite(){
        int a = - this.x;
        int b = - this.y;
        Vector2d oppo = new Vector2d(a,b);
        return oppo;
    }


}

class MoveDirection {
    public enum MoveDict{
        FORWARD,
        BACKWARD,
        RIGHT,
        LEFT
    }
}

class MapDirection {
    public enum MapDirect {
        NORTH,
        SOUTH,
        WEST,
        EAST;

        public String toString() {
            switch (this) {
                case NORTH:
                    return "Północ";
                case SOUTH:
                    return "Południe";
                case WEST:
                    return "Zachód";
                case EAST:
                    return "Wschód";
                default: return "Błędny argument";
            }
        }
        public MapDirect next() {
            switch (this) {
                case NORTH:
                    return EAST;
                case SOUTH:
                    return WEST;
                case WEST:
                    return NORTH;
                case EAST:
                    return SOUTH;
                default: return this;
            }
        }
        public MapDirect previous() {
            switch (this) {
                case NORTH:
                    return WEST;
                case SOUTH:
                    return EAST;
                case WEST:
                    return SOUTH;
                case EAST:
                    return NORTH;
                default: return this;
            }
        }

        public Vector2d toUnitVector() {
            switch (this) {
                case NORTH:
                    Vector2d up = new Vector2d(0,1);
                    return up;
                case SOUTH:
                    Vector2d down = new Vector2d(0,-1);
                    return down;
                case WEST:
                    Vector2d left = new Vector2d(-1,0);
                    return left;
                case EAST:
                    Vector2d right = new Vector2d(1,0);
                    return right;
                default:
                    Vector2d wrong = new Vector2d(0,0);
                    return wrong;
            }
        }

    }
}
public class World {
    static void run(ChoosePath[] array) {
        for (int i = 0; i < array.length; i++) {
            String output = switch (array[i]) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak skęca w lewo";
                case RIGHT -> "Zwierzak skręca w prawo";
            };
            out.println(output);
        }
    }

    public static ChoosePath[] FindPath(String[] array) {
        ChoosePath[] path = new ChoosePath[array.length];
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case "f" -> path[i] = ChoosePath.FORWARD;
                case "b" -> path[i] = ChoosePath.BACKWARD;
                case "l" -> path[i] = ChoosePath.LEFT;
                case "r" -> path[i] = ChoosePath.RIGHT;
            }
        }
        return path;
    }

    public static void main(String[] args) {

        out.println("system wystartował");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println(position1.opposite());
        ChoosePath[] path = FindPath(args);

        MapDirection.MapDirect move = MapDirection.MapDirect.SOUTH;
        out.println(move.toUnitVector());

        run(path);
        out.println("system zakończył działanie");
    }
}

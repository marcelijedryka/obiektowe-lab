package agh.ics.oop;
import static agh.ics.oop.Direction.ChoosePath;
import static java.lang.System.out;

public class World {
    static void run(ChoosePath[] array) {
        for (int i = 0; i < array.length; i++) {
            String output = switch (array[i]) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT ->"Zwierzak skęca w lewo";
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
        ChoosePath[] path = FindPath(args);
        run(path);
        out.println("system zakończył działanie");
    }
}

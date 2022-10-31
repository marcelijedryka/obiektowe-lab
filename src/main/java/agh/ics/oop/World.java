package agh.ics.oop;
import static agh.ics.oop.Direction.ChoosePath;
import static java.lang.System.out;

public class World {
    static void run(ChoosePath[] array) {
        for (ChoosePath choosePath : array) {
            String output = switch (choosePath) {
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

        /* Aby zaimplementować mechanizm, który wyklucza pojawienie się dwóch zwierząt w tym samym miejscu
        należy skorzystać z metody isAt. W metodzie move możemy dodać warunek, który zignoruje kolejny ruch
        zwierzęcia, jeśli ten spowoduje wejście na zajmowaną już pozyję.
         */

//        String[] ruchy2 = new String[] {"f" ,"b", "b", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        out.println(map);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        //run(path);
        out.println("system zakończył działanie");
    }
}

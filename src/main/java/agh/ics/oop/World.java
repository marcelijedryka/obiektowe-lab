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

        /*
        Inny sposób implementacji mapy w klasach RectangularMap oraz GrassField spowodował , że
        metody znacząco się od siebie różnią, a zatem w klasie Abstract World Map zaimplementowana jest tylko metoda toString()
         */

        /* 10. Dodanie interfejsu IMapElement mogłoby  spowodować uproszczenie implementacji klasy GrassField,
        ponieważ dzięki metodom zawartym w tym interfejsie moglibyśmy rozważać osobno występowanie poszczególnych
        obiektów na danym polu. Kod byłby bardziej klarowny.
        */

        /*11. O ile różnica w implementacji mapy dla klas RectangularMap oraz GrassField spowodowała , że
        prawie wszystkie metody różnią się od siebie, to w przypadku AbstractWorldMapElement implementacja takiej klasy
        miałaby sens (rozważanie występowania poszczególnych obiektów na danym polu przeprowadzane jest w taki sam sposób)
         */


//        String[] ruchy = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
//        String[] ruchy2 = new String[] {"l", "r", "f", "f", "f", "f", "f", "r", "f", "f", "f", "f", "f", "f", "f", "f","f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        out.println(map);
        engine.run();




        out.println("system zakończył działanie");
    }
}

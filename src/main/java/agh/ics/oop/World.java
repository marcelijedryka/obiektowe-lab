package agh.ics.oop;
import java.util.Scanner;
import static agh.ics.oop.Direction.ChoosePath;
import static java.lang.System.out;

public class World {
    static void run(ChoosePath[] array) {
        //out.println("Zwierzak idzie do przodu"); punkt 8
        // punkt 14
       /* Scanner sc = new Scanner(System.in);
        out.println("Wprowadź kierunek (f , b , r lub l)");
        String direction = sc.nextLine();
        String outcome = switch(direction) {
            case "f" -> "idzie do przodu";
            case "b" -> "idzie do tyłu";
            case "l" -> "skręca w lewo";
            case "r" -> "skęca w prawo";
            default -> "idzie w nieznaną stronę - błędna komenda";
        };
        out.println("Zwierzak " + outcome); */
        // punkt 15
        /*for (int i = 0; i < array.length; i++) {
            String outcome=switch (array[i]) {
                case "f" -> "idzie do przodu";
                case "b" -> "idzie do tyłu";
                case "l" -> "skręca w lewo";
                case "r" -> "skęca w prawo";
                default -> "idzie w nieznaną stronę - błędna komenda";
            };
            out.println("Zwierzak " + outcome);
        }*/


        // punkt 11
        /*for (int i = 0; i < array.length - 1; i++) {
            out.print(array[i] + "," + " ");
        }
        out.println(array[array.length - 1]);*/
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
        //String[] pets = {"dog", "cat", "mouse"}; punkt 11-12
        //String[] test = {"f" ,"f" ,"l" ,"r"};
        ChoosePath[] path = FindPath(args);
        run(path);
        out.println("system zakończył działanie");
    }
}

package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public MoveDirection[] parse(String[] args) {
        List<MoveDirection> moves = new ArrayList<MoveDirection>();
        for (String arg : args) {
            switch (arg) {
                case "f", "forward" -> moves.add(MoveDirection.FORWARD);
                case "b", "backward" -> moves.add(MoveDirection.BACKWARD);
                case "r", "right" -> moves.add(MoveDirection.RIGHT);
                case "l", "left" -> moves.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(arg + " is not legal move specification");

            }
        }
        MoveDirection[] output = new MoveDirection[moves.size()];
        for (int i = 0; i < moves.size(); i++) {
            output[i] = moves.get(i);
        }
        return output;
    }

}

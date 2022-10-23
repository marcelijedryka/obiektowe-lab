package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        List<MoveDirection> moves = new ArrayList<MoveDirection>();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f" -> moves.add(MoveDirection.FORWARD);
                case "forward" -> moves.add(MoveDirection.FORWARD);
                case "b" -> moves.add(MoveDirection.BACKWARD);
                case "backward" -> moves.add(MoveDirection.BACKWARD);
                case "r" -> moves.add(MoveDirection.RIGHT);
                case "right" -> moves.add(MoveDirection.RIGHT);
                case "l" -> moves.add(MoveDirection.LEFT);
                case "left" -> moves.add(MoveDirection.LEFT);

            }
        }
        MoveDirection[] output = new MoveDirection[moves.size()];
        for (int i = 0; i < moves.size(); i++) {
            output[i] = moves.get(i);
        }
        return output;
    }

}

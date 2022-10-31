package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        List<MoveDirection> moves = new ArrayList<MoveDirection>();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "f" , "forward" -> moves.add(MoveDirection.FORWARD);
                case "b" , "backward" -> moves.add(MoveDirection.BACKWARD);
                case "r" , "right" -> moves.add(MoveDirection.RIGHT);
                case "l" , "left" -> moves.add(MoveDirection.LEFT);


            }
        }
        MoveDirection[] output = new MoveDirection[moves.size()];
        for (int i = 0; i < moves.size(); i++) {
            output[i] = moves.get(i);
        }
        return output;
    }

}

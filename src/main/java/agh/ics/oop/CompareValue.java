package agh.ics.oop;

import java.util.Comparator;

public class CompareValue implements Comparator<Vector2d> {

    private int n;

    public CompareValue(String pos){
        if (pos.equals("x")){
            n = 0;
        }else{
            n = 1;
        }
    }

    @Override
    public int compare(Vector2d o1, Vector2d o2) {
        if (n == 0) {
            if (o1.x > o2.x) {
                return 1;
            } else if (o1.x < o2.x) {
                return -1;
            } else {
                if (o1.y > o2.y) {
                    return 1;
                } else if (o1.y < o2.y) {
                    return -1;
                }
                return 0;
            }
        } else {
            if (o1.y > o2.y) {
                return 1;
            } else if (o1.y < o2.y) {
                return -1;
            } else {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x < o2.x) {
                    return -1;
                }else {
                    return 0;
                }
            }
        }
    }
}
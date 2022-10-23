package agh.ics.oop;

public class Animal {
    private Vector2d current_position = new Vector2d(2, 2);
    private MapDirection current_orientation = MapDirection.NORTH;

    public String toString() {
        String pos = current_position.toString();
        String orient = current_orientation.toString();
        return pos + " " + orient;
    }

    public boolean isAt(Vector2d position) {
        return current_position.equals(position);
    }

    void move(MoveDirection direction) {
        Vector2d changed_position = new Vector2d(current_position.x, current_position.y);
        Vector2d map_edge_1 = new Vector2d(0, 0);
        Vector2d map_edge_2 = new Vector2d(4, 4);
        switch (direction) {
            case RIGHT -> current_orientation = current_orientation.next();
            case LEFT -> current_orientation = current_orientation.previous();
            case FORWARD -> changed_position = current_position.add(current_orientation.toUnitVector());
            case BACKWARD -> changed_position = current_position.substract(current_orientation.toUnitVector());
        }
        if (changed_position.precedes(map_edge_2) && changed_position.follows(map_edge_1)) {
            current_position = changed_position;
        }
    }
}



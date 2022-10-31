package agh.ics.oop;

public class RectangularMap implements IWorldMap {

    private final Object[][] map;
    private final Vector2d edge_1;
    private final Vector2d edge_2;

    public RectangularMap(int width, int height) {
        map = new Object[height][width];
        edge_1 = new Vector2d(width - 1, height - 1);
        edge_2 = new Vector2d(0, 0);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.x >= map[1].length || position.y >= map.length || position.x < 0 || position.y < 0){
            return false;
        }
        if (isOccupied(position)) {
            return false;
        }
        return position.precedes(edge_1) && position.follows(edge_2);
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getCurrent_position())) {
            return false;
        }
        map[animal.getCurrent_position().y][animal.getCurrent_position().x] = animal;
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (map[position.y][position.x] != null) {
            return true;
        }
        return false;

    }

    @Override
    public Object objectAt(Vector2d position) {
        if (!isOccupied(position)) {
            return null;
        }
        return map[position.y][position.x];
    }

    @Override
    public String toString() {
        MapVisualizer draw = new MapVisualizer(this);
        return draw.draw(edge_2,edge_1);
    }
    @Override
    public void removeAnimal(Vector2d position){
        map[position.y][position.x] = null;
    }
}

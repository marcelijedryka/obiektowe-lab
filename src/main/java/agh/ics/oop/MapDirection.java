package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        switch (this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case WEST:
                return "Zachód";
            case EAST:
                return "Wschód";
            default:
                return "Błędny argument";
        }
    }

    public MapDirection next() {
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
            default:
                return this;
        }
    }

    public MapDirection previous() {
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            case EAST:
                return NORTH;
            default:
                return this;
        }
    }

    public Vector2d toUnitVector() {
        switch (this) {
            case NORTH:
                Vector2d up = new Vector2d(0, 1);
                return up;
            case SOUTH:
                Vector2d down = new Vector2d(0, -1);
                return down;
            case WEST:
                Vector2d left = new Vector2d(-1, 0);
                return left;
            case EAST:
                Vector2d right = new Vector2d(1, 0);
                return right;
            default:
                Vector2d wrong = new Vector2d(0, 0);
                return wrong;
        }
    }

}


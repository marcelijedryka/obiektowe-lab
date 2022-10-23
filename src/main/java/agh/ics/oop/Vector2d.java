package agh.ics.oop;

public class Vector2d {
    final public int x;
    final public int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        String a = String.format("%d", this.x);
        String b = String.format("%d", this.y);
        return "(" + a + "," + b + ")";
    }

    public boolean precedes(Vector2d other) {
        if (this.x <= other.x && this.y <= other.y)
            return true;
        return false;
    }

    public boolean follows(Vector2d other) {
        if (this.x >= other.x && this.y >= other.y)
            return true;
        return false;
    }

    public Vector2d upperRight(Vector2d other) {
        int a = (this.x >= other.x) ? this.x : other.x;
        int b = (this.y >= other.y) ? this.y : other.y;
        Vector2d upright = new Vector2d(a, b);
        return upright;
    }

    public Vector2d lowerLeft(Vector2d other) {
        int a = (this.x <= other.x) ? this.x : other.x;
        int b = (this.y <= other.y) ? this.y : other.y;
        Vector2d loleft = new Vector2d(a, b);
        return loleft;
    }

    public Vector2d add(Vector2d other) {
        int a = this.x + other.x;
        int b = this.y + other.y;
        Vector2d summed = new Vector2d(a, b);
        return summed;
    }

    public Vector2d substract(Vector2d other) {
        int a = this.x - other.x;
        int b = this.y - other.y;
        Vector2d subtracted = new Vector2d(a, b);
        return subtracted;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if (this.x == that.x && this.y == that.y)
            return true;
        return false;
    }

    public Vector2d opposite() {
        int a = -this.x;
        int b = -this.y;
        Vector2d oppo = new Vector2d(a, b);
        return oppo;
    }
}


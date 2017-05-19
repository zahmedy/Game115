package edu.buffalo;

/**
 * A class for the (x, y) position on the game board
 */
public class Location{

    private final int x;
    private final int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    /**
     * Returns a new Location object translated from this tile by (dx, dy)
     * @param dx delta x
     * @param dy delta y
     * @return A new Tile translated (dx, dy) from this tile
     */
    public Location translated(int dx, int dy){
        return new Location(this.getX() + dx, this.getY() + dy);
    }
}

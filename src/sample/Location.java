package sample;

public class Location {

    private int row;
    private int col;
    private int dir;
    public static final int NORTH = 1, EAST = 2,
                        SOUTH = 3, WEST = 4;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
        dir = NORTH;
    }

    public Location(int row, int col, int dir) {
        this.row = row;
        this.col = col;
        this.dir = dir;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "Location{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}

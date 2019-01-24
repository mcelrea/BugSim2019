package sample;

public class Location {

    private int row;
    private int col;
    public static final int NORTH = 1, EAST = 2,
                        SOUTH = 3, WEST = 4;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
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

    public Location getAdjacentLocation(int dir) {
        if(dir == NORTH) {
            return new Location(this.row-1, this.col);
        }
        else if(dir == SOUTH) {
            return new Location(this.row+1, this.col);
        }
        else if(dir == EAST) {
            return new Location(this.row, this.col+1);
        }
        else if(dir == WEST) {
            return new Location(this.row, this.col-1);
        }

        return null;
    }

    @Override
    public String toString() {
        return "Location{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}

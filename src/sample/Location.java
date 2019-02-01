package sample;

public class Location {

    private int row;
    private int col;
    public static final int NORTH = 1, NORTHEAST = 2, EAST = 3,
                        SOUTHEAST = 4, SOUTH = 5, SOUTHWEST = 6,
                        WEST = 7, NORTHWEST = 8;

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
        else if(dir == NORTHEAST) {
            return new Location(this.row-1, this.col+1);
        }
        else if(dir == SOUTHEAST) {
            return new Location(this.row+1, this.col+1);
        }
        else if(dir == SOUTHWEST) {
            return new Location(this.row+1, this.col-1);
        }
        else if(dir == NORTHWEST) {
            return new Location(this.row-1, this.col-1);
        }

        return null;
    }

    public void setLocation(Location other) {
        row = other.row;
        col = other.col;
    }

    @Override
    public String toString() {
        return "Location{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}

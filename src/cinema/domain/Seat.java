package cinema.domain;

public class Seat {
    private boolean isOccupied = false;

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        return isOccupied ? "B" : "S";
    }
}

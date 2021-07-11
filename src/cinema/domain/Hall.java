package cinema.domain;

public class Hall {
    private Seat[][] seats;
    private int cash = 0;

    public Hall(int rowsAmount, int seatsAmount) {
        this.seats = new Seat[rowsAmount][seatsAmount];
        for (int i = 0; i < rowsAmount; i++) {
            for (int j = 0; j < seatsAmount; j++) {
                seats[i][j] = new Seat();
            }
        }
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void addCash(int amount) {
        this.cash += amount;
    }

    public int getCash() {
        return cash;
    }

    public boolean hasNoSeat(int rowToCheck, int seatToCheck) {
        return rowToCheck-1 >= seats.length || seatToCheck-1 >= seats[rowToCheck-1].length;
    }
}

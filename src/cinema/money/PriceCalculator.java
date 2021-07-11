package cinema.money;

import cinema.domain.Hall;

public class PriceCalculator {
    public static final int DEFAULT_TICKET_PRICE = 10;
    public static final int BACKROW_TICKET_PRICE = 8;
    public static final int SEATS_TRESHOLD = 60;

    private Hall hall;

    public PriceCalculator(Hall hall) {
        this.hall = hall;
    }

    public int calcIncome() {
        int rows = hall.getSeats().length;
        int seats = hall.getSeats()[0].length;
        if (rows * seats <= SEATS_TRESHOLD) {
            return rows * seats * DEFAULT_TICKET_PRICE;
        }
        int frontRows = Math.floorDiv(rows, 2);
        int frontRowsIncome = frontRows * seats * DEFAULT_TICKET_PRICE;
        int backRowsIncome = (rows - frontRows) * seats * BACKROW_TICKET_PRICE;
        return frontRowsIncome + backRowsIncome;
    }

}

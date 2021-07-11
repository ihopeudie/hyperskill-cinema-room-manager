package cinema.ui;

import cinema.domain.Hall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicketsSeller {
    public static final int DEFAULT_TICKET_PRICE = 10;
    public static final int BACKROW_TICKET_PRICE = 8;
    public static final int SEATS_TRESHOLD = 60;

    public void buyTicket(Hall hall, BufferedReader reader) throws IOException {
        int rowToCheck = 0;
        int seatToCheck = 0;
        boolean isExit = false;
        while (!isExit) {
            try {
                System.out.println("Enter a row number:");
                rowToCheck = Integer.parseInt(reader.readLine());
                System.out.println("Enter a seat number in that row:");
                seatToCheck = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Wrong input!");
                continue;
            }
            if (hall.hasNoSeat(rowToCheck, seatToCheck)) {
                System.out.println("Wrong input!");
                continue;
            }
            if (hall.getSeats()[rowToCheck-1][seatToCheck-1].isOccupied()) {
                System.out.println("That ticket has already been purchased!");
                continue;
            }
            isExit = true;
        }
        System.out.println();
        int price = checkPrice(hall, rowToCheck);
        System.out.printf("Ticket price: $%d%n%n", price);
        hall.getSeats()[rowToCheck - 1][seatToCheck - 1].setOccupied(true);
        hall.addCash(price);
    }

    private int checkPrice(Hall hall, int rowToCheck) {
        if (hall.getSeats().length * hall.getSeats()[0].length <= SEATS_TRESHOLD) {
            return DEFAULT_TICKET_PRICE;
        }
        if (rowToCheck > Math.floorDiv(hall.getSeats().length, 2)) {
            return BACKROW_TICKET_PRICE;
        } else {
            return DEFAULT_TICKET_PRICE;
        }
    }

}

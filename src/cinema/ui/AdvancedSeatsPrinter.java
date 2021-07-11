package cinema.ui;

import cinema.domain.Seat;

public class AdvancedSeatsPrinter {

    public void printSeats(Seat[][] seats) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cinema:");
        sb.append(System.lineSeparator());
        sb.append("  ");
        for (int i = 1; i <= seats[0].length; i++) {
            sb.append(i);
            sb.append(i == seats[0].length ? "" : " ");
        }
        sb.append(System.lineSeparator());
        for (int i = 0; i < seats.length; i++) {
            sb.append(i + 1);
            sb.append(" ");
            for (int j = 0; j < seats[0].length; j++) {
                sb.append(seats[i][j].toString());
                sb.append(i == seats[0].length ? "" : " ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}

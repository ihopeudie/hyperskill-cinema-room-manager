package service;

import cinema.domain.Hall;
import cinema.domain.Seat;
import cinema.money.PriceCalculator;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Stream;

public class StatsHolder {

    private Hall hall;
    private int totalIncome = 0;

    public StatsHolder(Hall hall) {
        this.hall = hall;
        this.totalIncome = calcTotalIncome();
    }

    private int calcTotalIncome() {
        return new PriceCalculator(hall).calcIncome();
    }

    @Override
    public String toString() {
        return String.format("Number of purchased tickets: %d%nPercentage: %s%nCurrent income: $%d%nTotal income: $%d%n",
                getPurchasedTicketsAmount(), calcPercentage(), calcIncome(), totalIncome);
    }

    private long getPurchasedTicketsAmount() {
        return Arrays.stream(hall.getSeats()).flatMap(Stream::of).filter(Seat::isOccupied).count();
    }

    private int getAllTicketsAmount() {
        return hall.getSeats().length * hall.getSeats()[0].length;
    }

    private int calcIncome() {
        return hall.getCash();
    }

    private String calcPercentage() {
        return new DecimalFormat("0.00%")
                .format(((float)getPurchasedTicketsAmount() / (float)getAllTicketsAmount()))
                .replace(",", ".");
    }
}

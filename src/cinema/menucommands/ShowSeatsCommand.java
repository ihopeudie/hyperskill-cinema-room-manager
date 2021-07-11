package cinema.menucommands;

import cinema.domain.Hall;
import cinema.ui.AdvancedSeatsPrinter;

public class ShowSeatsCommand implements MenuCommand {
    AdvancedSeatsPrinter printer = new AdvancedSeatsPrinter();

    @Override
    public void menuAction(Hall hall) {
        printer.printSeats(hall.getSeats());
    }
}

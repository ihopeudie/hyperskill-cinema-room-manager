package cinema.menucommands;

import cinema.domain.Hall;
import cinema.ui.TicketsSeller;

import java.io.BufferedReader;

public class BuyTicketsCommand implements MenuCommand {
    private BufferedReader reader;
    TicketsSeller seller = new TicketsSeller();

    public BuyTicketsCommand() {
    }

    public BuyTicketsCommand(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void menuAction(Hall hall) {
        try {
            seller.buyTicket(hall, reader);
        } catch (Exception e) {
            System.out.println("errro");
        }
    }
}

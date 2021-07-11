package cinema;

import cinema.domain.Hall;
import cinema.menucommands.BuyTicketsCommand;
import cinema.menucommands.MenuCommand;
import cinema.menucommands.ShowSeatsCommand;
import cinema.menucommands.StatisticsCommand;
import cinema.ui.Menu;
import service.StatsHolder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CinemaManager {
    private Hall hall;
    private StatsHolder statsHolder;

    public void manage() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Enter the number of rows:");
            int rows = Integer.parseInt(reader.readLine());
            System.out.println("Enter the number of seats in each row:");
            int seats = Integer.parseInt(reader.readLine());
            this.hall = new Hall(rows, seats);
            this.statsHolder = new StatsHolder(hall);
            System.out.println();

            Menu menu = new Menu();
            boolean isExit = false;
            while (!isExit) {
                menu.printMenu();
                int code = (Integer.parseInt(reader.readLine()));
                MenuCommand command = null;
                switch (code) {
                    case 1:
                        command = new ShowSeatsCommand();
                        break;
                    case 2:
                        command = new BuyTicketsCommand(reader);
                        break;
                    case 3:
                        command = new StatisticsCommand(statsHolder);
                        break;
                    default:
                        isExit = true;
                        break;
                }
                if (command != null) {
                    command.menuAction(hall);
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}

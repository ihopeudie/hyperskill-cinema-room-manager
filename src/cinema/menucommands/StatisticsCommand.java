package cinema.menucommands;

import cinema.domain.Hall;
import service.StatsHolder;

public class StatisticsCommand implements MenuCommand {
    private StatsHolder statsHolder;

    public StatisticsCommand() {
    }

    public StatisticsCommand(StatsHolder statsHolder) {
        this.statsHolder = statsHolder;
    }

    @Override
    public void menuAction(Hall hall) {
        System.out.println(statsHolder);
    }
}

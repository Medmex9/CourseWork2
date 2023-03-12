package Servise;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class DailyTask extends Task {

    public DailyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.isBefore(ChronoLocalDate.from(getDataTime()));
    }

}

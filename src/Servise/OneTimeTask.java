package Servise;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.isBefore(ChronoLocalDate.from(getDataTime()));
    }
}

package Servise;

import Servise.Task;
import Servise.Type;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.isBefore(ChronoLocalDate.from(getDataTime()));
    }
}

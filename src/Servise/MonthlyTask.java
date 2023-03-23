package Servise;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.getDayOfMonth() == this.getDataTime().getDayOfMonth() && date.
                isAfter(this.getDataTime().toLocalDate()) || date.
                isEqual(this.getDataTime().toLocalDate());
    }
}

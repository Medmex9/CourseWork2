package Servise;

import java.time.LocalDate;
public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.getDayOfMonth() == this.getDataTime().
                getDayOfMonth() && date.getMonth() == this.getDataTime().
                getMonth() && date.isAfter(this.getDataTime().
                toLocalDate()) || date.isEqual(this.getDataTime().toLocalDate());
    }
}

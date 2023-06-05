package Servise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator;
    private String title;
    private Type type;
    private Integer id;
    private LocalDateTime dataTime;
    private String description;

    public Task(String title, Type type, String description) {
        idGenerator++;
        this.title = title;
        this.type = type;
        this.dataTime = dataTime.now();
        this.id = idGenerator;
        this.description = description;
    }

    public abstract boolean appearsIn(LocalDate date);

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getidGenerator() {
        return idGenerator;
    }

    public Type getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public String getDescription() {
        return description;
    }
    public static void printTask() {
        System.out.println(Task.idGenerator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id);
    }
// Для поиска нам нужно id/ Оставляю его только
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Название" + title + '\'' +
                "Тип задачи" + type + ", Описание задачи '" + description + ", id=" + id +
                ", Создана" + dataTime + dataTime.get(ChronoField.YEAR) + dataTime.get(ChronoField.MONTH_OF_YEAR)
                 + dataTime.get(ChronoField.DAY_OF_MONTH);
    }
}

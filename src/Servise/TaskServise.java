package Servise;

import java.time.LocalDate;
import java.util.*;

import static Servise.Type.PERSONAL;
import static Servise.Type.WORKING;

public class TaskServise {
    static private Map<Integer, Task> taskMap = new HashMap<>();

    public static void start() {
        while (true) {
            System.out.println("Приветствую!  \n" + "Вас приветствует планировщик задач, чтобы начать работу" +
                    " Выберите номер действия \n" +
                    "1. Создать новую задачу; \n" +
                    "2. Удаление созданной задачи; \n" +
                    "3. Увидеть список созданных задач.");
            switch (new Scanner(System.in).nextLine()) {
                case ("1"):
                    newTask();
                    break;
                case ("2"):
                    deleteTask();
                    break;
                case ("3"):
                    getTaskDate();
                    break;
                default:
                    throw new IncorrectArgumentException("Такой задачи нет");
            }
        }
    }

    public static void newTask() {
        while (true) {
            System.out.println("Укажите название задачи");
            String title = new Scanner(System.in).nextLine();
            if (title == null || title.isEmpty()) {
                System.out.println("У задачи обязательно название");
                break;
            }

            System.out.println("Укажите тип задачи \n 1. Личная \n 2. Рабочая");
            Scanner scanner = new Scanner(System.in);
            Type type;
            int AV = scanner.nextInt();
            if (AV == 1) {
                type = PERSONAL;
            } else if (AV == 2) {
                type = WORKING;
            } else {
                System.out.println("Нужно выбрать значение 1 или 2");
                break;
            }
            System.out.println("Введите описание задачи");
            String description = new Scanner(System.in).nextLine();
            if (description.isBlank()) {
                System.out.println("Описание задачи не может быть пустым!");
                break;
            }

            System.out.println("Укажите повторяемость задачи \n 1 - Ежегодная,\n 2 - Ежемесячная,\n 3 - Еженедельная," +
                    "\n 4 - Ежедневная,\n 5 - Однократная");
            Task task = null;
            switch (new Scanner(System.in).nextLine()) {
                case ("1"):
                    task = new YearlyTask(title, type, description);
                    break;
                case ("2"):
                    task = new MonthlyTask(title, type, description);
                    break;
                case ("3"):
                    task = new WeeklyTask(title, type, description);
                    break;
                case ("4"):
                    task = new DailyTask(title, type, description);
                    break;
                case ("5"):
                    task = new OneTimeTask(title, type, description);
                    break;
                default:
                    throw new IncorrectArgumentException("Укажите цифровое значение из предложенных вариантов");

            }
            System.out.println("Задача создана \n \n");

            TaskServise.taskMap.put(task.getId(), task);
            break;
        }
    }

    public static void deleteTask() {
        System.out.print("введите id задачи которую хотите удалить: ");
        int id = new Scanner(System.in).nextInt();
        if (taskMap.get(id) == null) {
            throw new IncorrectArgumentException("Задачи с таким ID нет");
        }
        taskMap.remove(id);
        System.out.println("Таблица успешно удалена");
    }

    public static void getTaskDate() {
        Collection<Task> taskDate = new ArrayList<>();
        System.out.println("Введите год");
        int year = new Scanner(System.in).nextInt();
        System.out.println("Введите месяц");
        int month = new Scanner(System.in).nextInt();
        System.out.println("Введите день");
        int day = new Scanner(System.in).nextInt();
        LocalDate date1 = LocalDate.of(year, month, day);
        for (Task value : taskMap.values()) {
            if (value.appearsIn(LocalDate.from(date1.atStartOfDay()))) {
                taskDate.add(value);
            }
            if (taskDate.isEmpty()) {
                throw new IncorrectArgumentException("Задач на этот день нет");
                // ломаем
            }
            taskDate.forEach(System.out::println);

        }
    }

    public static void printMap() {
        for (Map.Entry<Integer, Task> entry : taskMap.entrySet()) {
            System.out.println(taskMap);
        }
    }

    @Override
    public String toString() {
        return " TaskService " +
                " Мапа задач" + taskMap;


    }
}







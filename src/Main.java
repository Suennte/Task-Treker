import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    private static List<NewTask> newTasks = new ArrayList<>();

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while (true){
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Новая задача");
            System.out.println("2 - Список задач");
            System.out.println("3 - Поиск задачи по индекатору");
            System.out.println("4 - Удаление всех задач");
            System.out.println("5 - Обновление задачи");
            System.out.println("6 - Удаление задачи по индекатору");
            System.out.println("7 - Список задач по статусу");
            System.out.println("0 - Выход");
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    System.out.println("Введите название задачи");
                    String taskName = scanner.nextLine();
                    System.out.println("Введите описание задачи");
                    String description = scanner.nextLine();
                    newTasks.add(new NewTask(taskName, description, Status.NEW));
                    changeStatus();
                    break;
                case 2:
                    for (NewTask task : newTasks) {
                        System.out.println(task);
                    }
                    break;
                case 3:
                    System.out.println("Введите индекатор задачи");
                    int numberTask = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    for (NewTask task : newTasks) {
                        if (task.getId() == numberTask){
                            System.out.println(task);
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Неверный ввод индекатора");
                    }
                    break;
                case 4:
                    newTasks.clear();
                    break;
                case 5:
                    System.out.println("Введите индекатор задачи");
                    int numberTasks = scanner.nextInt();
                    scanner.nextLine();
                    found = false;
                    for (NewTask task : newTasks) {
                        if (task.getId() == numberTasks){
                            System.out.println("Введите название задачи");
                            String updateTaskName = scanner.nextLine();
                            task.setTaskName(updateTaskName);
                            System.out.println("Введите описание задачи");
                            String updateDescription = scanner.nextLine();
                            task.setDescription(updateDescription);
                            task.setPriority(Status.NEW);
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Неверный ввод индекатора");
                    }
                    break;
                case 6:
                    System.out.println("Введите номер индекатора");
                    int deleteNumber = scanner.nextInt();
                    scanner.nextLine();
                    found = false;
                    for (int i = 0; i < newTasks.size(); i++) {
                        if (newTasks.get(i).getId() == deleteNumber) {
                            newTasks.remove(i);
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Неверный ввод индекатора");
                    }
                    break;
                case 7:
                    System.out.println("Введите статус задачи (1 - NEW, 2 - IN_PROGRESS, 3 - DONE)");
                    int statusTask = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера
                    Status status = null;
                    switch (statusTask) {
                        case 1:
                            status = Status.NEW;
                            break;
                        case 2:
                            status = Status.IN_PROGRESS;
                            break;
                        case 3:
                            status = Status.DONE;
                            break;
                        default:
                            System.out.println("Неверный ввод статуса");
                            break;
                    }
                    if (status != null) {
                        for (NewTask task : newTasks) {
                            if (task.getPriority() == status) {
                                System.out.println(task);
                            }
                        }
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Неверное число!");
            }
        }
    }
    static void changeStatus() {
        for (NewTask task : newTasks) {
            if (task.getId() > 1) {
                task.setPriority(Status.IN_PROGRESS);
            }
            if (task.getPriority() == Status.IN_PROGRESS && (task.getDescription().isEmpty()) || task.getPriority() == Status.NEW && (task.getDescription().isEmpty())) {
                task.setPriority(Status.DONE);
            }
        }
    }
}

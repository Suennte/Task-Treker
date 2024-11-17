public class NewTask {
    private static int nextId = 1;
    private int id;
    private String taskName;
    private String description;
    private Status priority;

    public Status getPriority() {
        return priority;
    }

    public void setPriority(Status priority) {
        this.priority = priority;
    }

    public NewTask(String taskName, String description, Status priority) {
        this.id = nextId++;
        this.taskName = taskName;
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Задача{" +
                "№" + id + '\'' +
                "Название='" + taskName + '\'' +
                ", Описание='" + description + '\'' +
                ", Приоритет=" + priority +
                '}';
    }
}
public class Task {
    private String name;
    private String description;
    private String dueDate;
    private int priority;
    private boolean ongoing;

    public Task(String name, String description, String dueDate, int priority) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.ongoing = true;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void markAsFinished() {
        this.ongoing = false;
    }
}

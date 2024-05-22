public class TaskManager {
    public Task[] tasks;
    public int taskCount;

    public TaskManager(int maxSize) {
        tasks = new Task[maxSize];
        taskCount = 0;
    }

    public void addTask(Task task) {
        if (taskCount < tasks.length) {
            tasks[taskCount++] = task;
            System.out.println("Task added successfully!");
        } 
        else {
            System.out.println("Task list is full!");
        }
    }

    public void displayTasks() {
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %-20s | %-30s | %-12s | %-8s | %-8s |\n", "Name", "Description", "Due Date", "Status", "Priority");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < taskCount; i++) {
            Task task = tasks[i];
            System.out.printf("| %-20s | %-30s | %-12s | %-8s | %-8d |\n",
                    task.getName(), task.getDescription(), task.getDueDate(),
                    task.isOngoing() ? "Ongoing" : "Finished", task.getPriority());
        }
        System.out.println("---------------------------------------------------------");
    }

    public void markTaskAsFinished(String taskName) {
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getName().equalsIgnoreCase(taskName)) {
                tasks[i].markAsFinished();
                System.out.println("Task marked as finished: " + taskName);
                return;
            }
        }
        System.out.println("Task not found: " + taskName);
    }

    public void deleteAllTasks() {
        taskCount = 0;
    }
}

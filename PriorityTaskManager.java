public class PriorityTaskManager extends TaskManager {
    private boolean taskFound;
    public PriorityTaskManager(int maxSize) {
        super(maxSize);
    }


    @Override
    public void addTask(Task task) {
        if (taskCount < tasks.length) { 
            tasks[taskCount] = task;
            taskCount++; 
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Task list is full!");
        }
    }


    @Override
    public void markTaskAsFinished(String taskName) {
        taskFound = false;
        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].getName().equalsIgnoreCase(taskName)) {
                tasks[i].markAsFinished();
                System.out.println("Task marked as finished: " + taskName);
                taskFound = true;
                return;
            }
        }
        System.out.println("Task not found: " + taskName);
    }

    public boolean isTaskFound() {
        return taskFound;
    }

    public String getTaskListAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---------------------------------------------------------\n");
        stringBuilder.append(String.format("| %-20s | %-30s | %-12s | %-8s | %-8s |\n", "Name", "Description", "Due Date", "Status", "Priority"));
        stringBuilder.append("---------------------------------------------------------\n");
        for (int i = 0; i < taskCount; i++) {
            Task task = tasks[i];
            stringBuilder.append(String.format("| %-20s | %-30s | %-12s | %-8s | %-8d |\n",
                    task.getName(), task.getDescription(), task.getDueDate(),
                    task.isOngoing() ? "Ongoing" : "Finished", task.getPriority()));
        }
        stringBuilder.append("---------------------------------------------------------\n");
        return stringBuilder.toString();
    }
}

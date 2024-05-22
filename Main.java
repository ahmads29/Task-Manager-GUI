// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         PriorityTaskManager priorityTaskManager = new PriorityTaskManager(100);

//         while (true) {
//             System.out.println("1. Add Task");
//             System.out.println("2. Display Tasks");
//             System.out.println("3. Mark Task as Finished");
//             System.out.println("4. Delete All Tasks");
//             System.out.println("5. Exit");
//             System.out.print("Enter your choice: ");
//             int choice = scanner.nextInt();
//             scanner.nextLine();

//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter Task Name: ");
//                     String name = scanner.nextLine();
//                     System.out.print("Enter Task Description: ");
//                     String description = scanner.nextLine();
//                     System.out.print("Enter Due Date: ");
//                     String dueDate = scanner.nextLine();
//                     System.out.print("Enter Task Priority (1-100): ");
//                     int priority = scanner.nextInt();
//                     scanner.nextLine();
//                     Task taskToAdd = new Task(name, description, dueDate, priority);
//                     priorityTaskManager.addTask(taskToAdd);
//                     break;
//                 case 2:
//                     priorityTaskManager.displayTasks();
//                     break;
//                 case 3:
//                     System.out.print("Enter Task Name to mark as finished: ");
//                     String taskName = scanner.nextLine();
//                     priorityTaskManager.markTaskAsFinished(taskName);
//                     break;
//                 case 4:
//                     priorityTaskManager.deleteAllTasks();
//                     System.out.println("All tasks deleted successfully");
//                     break;
//                 case 5:
//                     System.out.println("Exiting...");
//                     System.exit(0);
//                 default:
//                     System.out.println("Invalid choice. Please enter again.");
//             }
//         }
//     }
// }

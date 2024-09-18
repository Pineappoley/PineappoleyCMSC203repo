package tskmaster;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskMaster {
    private static List<Task> tasks = new ArrayList<>();
    private static StreakTracker streakTracker = new StreakTracker();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Load tasks from the file
        TaskSaver.loadTasks(tasks);

        while (true) {
            System.out.println("\n--- Task Master ---");
            TaskReminder.checkForReminders(tasks);
            System.out.println("Task List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }

            System.out.println("\nOptions:");
            System.out.println("1. Add a new task");
            System.out.println("2. Complete a task");
            System.out.println("3. Save and exit");
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                addNewTask(scanner);
            } else if (input.equals("2")) {
                completeTask(scanner);
            } else if (input.equals("3")) {
                TaskSaver.saveTasks(tasks);
                System.out.println("Exiting Task Master...");
                break;
            }
        }

        scanner.close();
    }

    private static void addNewTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());

        Task newTask = new Task(name, description, dueDate);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask);
    }

    private static void completeTask(Scanner scanner) {
        System.out.print("Enter the number of the task you completed: ");
        int taskNumber = Integer.parseInt(scanner.nextLine()) - 1;

        if (taskNumber >= 0 && taskNumber < tasks.size()) {
            Task task = tasks.get(taskNumber);
            if (!task.isCompleted()) {
                task.completeTask();
                streakTracker.completeTaskOnDate(LocalDate.now());
                RewardSystem.sendRewardMessage(task.getName());
            } else {
                System.out.println("Task is already completed.");
            }
        } else {
            System.out.println("Invalid task number.");
        }
    }
}

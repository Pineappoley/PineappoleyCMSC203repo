package tskmaster;

import java.time.LocalDate;
import java.util.List;

public class TaskReminder {

    public static void checkForReminders(List<Task> tasks) {
        LocalDate today = LocalDate.now();

        System.out.println("Checking for reminders...");
        for (Task task : tasks) {
            if (!task.isCompleted() && task.getDueDate().equals(today)) {
                System.out.println("Reminder: Task '" + task.getName() + "' is due today!");
            }
        }
    }
}

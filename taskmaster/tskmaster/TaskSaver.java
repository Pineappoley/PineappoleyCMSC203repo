package tskmaster;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class TaskSaver {

    private static final String FILE_NAME = "tasks.txt";

    public static void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                String taskLine = task.getName() + "," + task.getDescription() + "," + task.getDueDate() + "," + task.isCompleted();
                writer.write(taskLine);
                writer.newLine();
            }
            System.out.println("Tasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static void loadTasks(List<Task> tasks) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] taskData = line.split(",");
                String name = taskData[0];
                String description = taskData[1];
                LocalDate dueDate = LocalDate.parse(taskData[2]);
                boolean isCompleted = Boolean.parseBoolean(taskData[3]);

                Task task = new Task(name, description, dueDate);
                if (isCompleted) {
                    task.completeTask();  // Mark task as completed if it was saved that way
                }
                tasks.add(task);
            }
            System.out.println("Tasks loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}

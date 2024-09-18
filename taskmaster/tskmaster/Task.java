package tskmaster;

import java.time.LocalDate;

public class Task {
    private String name;
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;

    public Task(String name, String description, LocalDate dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeTask() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "Task: " + name + " | Due: " + dueDate + " | Completed: " + isCompleted;
    }
}


package tskmaster;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class StreakTracker {
    private int streak;
    private Map<LocalDate, Boolean> taskCompletionHistory;

    public StreakTracker() {
        this.streak = 0;
        this.taskCompletionHistory = new HashMap<>();
    }

    public void completeTaskOnDate(LocalDate date) {
        taskCompletionHistory.put(date, true);
        streak++;
        System.out.println("Current streak: " + streak);
    }

    public void missedTaskOnDate(LocalDate date) {
        taskCompletionHistory.put(date, false);
        streak = 0; // Reset the streak
        System.out.println("You missed a task. Streak reset to 0.");
    }

    public int getStreak() {
        return streak;
    }
}

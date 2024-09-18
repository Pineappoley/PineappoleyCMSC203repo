package ftrack;

import java.util.Scanner;

public class FitTrack {

    // Method to calculate Basal Metabolic Rate (BMR)
    public static double calculateBMR(double weight, double height, int age, String gender) {
        if (gender.equalsIgnoreCase("male")) {
            return 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age); // BMR formula for males
        } else if (gender.equalsIgnoreCase("female")) {
            return 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age); // BMR formula for females
        }
        return 0;
    }

    // Method to suggest calorie intake
    public static double suggestCalories(double bmr, String activityLevel) {
        switch (activityLevel.toLowerCase()) {
            case "sedentary":
                return bmr * 1.2;
            case "light":
                return bmr * 1.375;
            case "moderate":
                return bmr * 1.55;
            case "active":
                return bmr * 1.725;
            case "very active":
                return bmr * 1.9;
            default:
                return bmr * 1.2; // Default to sedentary
        }
    }

    // Method to suggest exercise duration
    public static String suggestExercise(double bmr) {
        if (bmr < 1500) {
            return "30 minutes of light exercise, such as walking or stretching.";
        } else if (bmr < 2000) {
            return "45 minutes of moderate exercise, such as jogging or swimming.";
        } else {
            return "1 hour of intense exercise, such as running or weight training.";
        }
    }

    // Method to reward the user for progress
    public static void rewardUser(double weightChange) {
        if (weightChange > 0) {
            System.out.println("Congratulations! You've gained weight. Keep up the good work!");
        } else if (weightChange < 0) {
            System.out.println("Great job! You've lost weight. Keep building healthy habits!");
        } else {
            System.out.println("You're maintaining your weight perfectly. Stay consistent!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User inputs
        System.out.println("Welcome to Fit Track!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your height (in cm): ");
        double height = scanner.nextDouble();

        System.out.print("Enter your weight (in kg): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your gender (male/female): ");
        String gender = scanner.next();

        System.out.print("Enter your resting heart rate (beats per minute): ");
        int heartRate = scanner.nextInt();

        System.out.print("Enter your activity level (sedentary, light, moderate, active, very active): ");
        String activityLevel = scanner.next();

        // Calculate BMR and suggest calories
        double bmr = calculateBMR(weight, height, age, gender);
        double recommendedCalories = suggestCalories(bmr, activityLevel);
        String exerciseSuggestion = suggestExercise(bmr);

        // Display results
        System.out.println("\n=== Fit Track Summary ===");
        System.out.println("Name: " + name);
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Age: " + age + " years");
        System.out.println("Heart Rate: " + heartRate + " bpm");
        System.out.println("Gender: " + gender);
        System.out.println("Activity Level: " + activityLevel);
        System.out.printf("Your Basal Metabolic Rate (BMR) is: %.2f calories/day\n", bmr);
        System.out.printf("Recommended daily calorie intake: %.2f calories\n", recommendedCalories);
        System.out.println("Suggested exercise: " + exerciseSuggestion);

        // Track progress (e.g., weight change)
        System.out.print("\nEnter your weight after progress: ");
        double newWeight = scanner.nextDouble();
        double weightChange = newWeight - weight;

        rewardUser(weightChange);

        System.out.println("Thank you for using Fit Track! Keep going on your fitness journey!");
        
        scanner.close();
    }
}

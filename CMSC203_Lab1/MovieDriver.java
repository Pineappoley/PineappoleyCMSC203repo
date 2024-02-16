package moviefiles;
import java.util.Scanner;

public class MovieDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueInput;

        do {
            // Create new movie object
            Movie movie = new Movie();

            // user enter title of movie
            System.out.println("Enter the title of the movie:");
            String title = scanner.nextLine();
            // Set the title in the movie object
            movie.setTitle(title);

            // user enter movie rating
            System.out.println("Enter the rating of the movie:");
            String rating = scanner.nextLine();
            // Set the rating in the movie object
            movie.setRating(rating);

            //  user enter number of tickets 
            System.out.println("Enter the number of tickets sold:");
            int ticketsSold = scanner.nextInt();
            // Set the number of tickets sold in the movie object
            movie.setSoldTickets(ticketsSold);

            // Print out movie information 
            System.out.println(movie.toString());
  
            scanner.nextLine();

            // to continue
            System.out.println("Do you want to enter another movie? (y or n)");
            continueInput = scanner.nextLine();
        } while (continueInput.equalsIgnoreCase("y"));

        scanner.close();

        System.out.println("Goodbye");

    }
}

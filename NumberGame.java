import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalRoundsWon = 0;
        int totalRoundsPlayed = 0;

        System.out.println("=== Welcome to the Number Game ===");

        while (playAgain) {
            totalRoundsPlayed++;
            System.out.println("\n--- Round " + totalRoundsPlayed + " ---");

            // 1. Generate a random number between 1 and 100
            int targetNumber = random.nextInt(100) + 1;
            
            // 5. Limit the number of attempts (e.g., 7 attempts)
            int maxAttempts = 7;
            int attemptsLeft = maxAttempts;
            boolean hasGuessedCorrectly = false;

            System.out.println("I have picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            // Loop for user guesses
            while (attemptsLeft > 0) {
                System.out.print("\nEnter your guess (" + attemptsLeft + " attempts remaining): ");

                // Validate that input is an integer
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // clear invalid input
                    System.out.print("Enter your guess: ");
                }
                int userGuess = scanner.nextInt();

                // 3. Compare user's guess and provide feedback
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    hasGuessedCorrectly = true;
                    totalRoundsWon++;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                attemptsLeft--;
            }

            // If user ran out of attempts
            if (!hasGuessedCorrectly) {
                System.out.println("\nOut of attempts! The correct number was: " + targetNumber);
            }

            // 7. Display user's score summary for the session
            System.out.println("--- Scoreboard ---");
            System.out.println("Rounds Played: " + totalRoundsPlayed);
            System.out.println("Rounds Won: " + totalRoundsWon);

            // 6. Option for multiple rounds, allowing the user to play again
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
        }

        System.out.println("\nThank you for playing! Final Score - Rounds Won: " + totalRoundsWon + "/" + totalRoundsPlayed);
        scanner.close();
    }
}
import java.util.Random;
import java.util.Scanner;

public class num_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1; // Minimum number in the range
        int maxRange = 100; // Maximum number in the range
        int attemptsLimit = 5; // Number of attempts allowed

        int totalRounds = 0;
        int totalScore = 0;

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have chosen a number between " + minRange + " and " + maxRange +
                    ". Guess it within " + attemptsLimit + " attempts.");

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " +
                            attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += attempts;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. " +
                        "The correct number was: " + targetNumber);
            }

            totalRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
        System.out.println("Total Rounds: " + totalRounds);
        System.out.println("Total Score: " + totalScore);
        scanner.close();
    }
}

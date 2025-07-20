import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess a number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    score += (maxAttempts - attempts + 1) * 10;
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts. The number was " + numberToGuess);
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.next();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing! Final score: " + score);
            }
        }
        sc.close();
    }
}

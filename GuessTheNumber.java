import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rounds = 3; // Number of rounds
        int maxAttempts = 5; // Maximum attempts per round
        int totalScore = 0;
        
        System.out.println("Welcome to Guess the Number Game!");
        
        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("\nRound " + round + " begins!");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1) * 10; // Score based on attempts
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry! The correct number was: " + numberToGuess);
            }
        }
        
        System.out.println("\nGame Over! Your total score: " + totalScore);
        scanner.close();
    }
}

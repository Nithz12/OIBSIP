import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int round = 1;
        boolean playAgain = true;

        System.out.println("=====================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=====================================");

        while (playAgain) {

            System.out.println("\nChoose Difficulty");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.print("Enter your choice: ");

            int difficultyChoice = sc.nextInt();

            int maxNumber;
            int maxAttempts;

            switch (difficultyChoice) {
                case 1:
                    maxNumber = 50;
                    maxAttempts = 10;
                    break;

                case 2:
                    maxNumber = 100;
                    maxAttempts = 7;
                    break;

                case 3:
                    maxNumber = 200;
                    maxAttempts = 5;
                    break;

                default:
                    System.out.println("Invalid choice! Medium difficulty selected.");
                    maxNumber = 100;
                    maxAttempts = 7;
            }

            int randomNumber = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\n---------- Round " + round + " ----------");
            System.out.println("Guess a number between 1 and " + maxNumber);

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess > randomNumber) {
                    System.out.println("Too High!");
                } else if (guess < randomNumber) {
                    System.out.println("Too Low!");
                } else {
                    guessed = true;
                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the number in " + attempts + " attempt(s).");
                    break;
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("\n========== Round Summary ==========");
            System.out.println("Round : " + round);

            if (guessed) {
                System.out.println("Status : WON");
                System.out.println("Attempts Used : " + attempts);
            } else {
                System.out.println("Status : LOST");
            }

            System.out.println("===================================");

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainChoice = sc.next();

            if (!playAgainChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }

            round++;
        }

        System.out.println("\nThank you for playing!");
        sc.close();
    }
}
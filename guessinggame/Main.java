import java.util.Random;
import java.util.Scanner;

public class Main {
     
    private static final int START = 1;
    private static final int END = 100;
    private static final int MAX_ATTEMPTS = 10;
     
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int roundsPlayed = 0;
        int totalAttempts = 0;
        int roundsWon = 0;

        while (true) {
            System.out.println("Round" + (roundsPlayed + 1));
            int attempts = playGame(sc);
            if (attempts > 0) {
                totalAttempts += attempts;
                roundsWon += 1;
            }
            roundsPlayed += 1;
             
            System.out.print("Do you want to play again? (yes/no):");
            String playAgain = sc.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        System.out.println("Total rounds played: " + roundsPlayed);
        System.out.println("Rounds Won:" + roundsWon);
        if (roundsWon > 0) {
            System.out.println((double) totalAttempts / roundsWon);  
        } else{
            System.out.println("You didn't win any rounds.");
        }
        System.out.println("Thanks for playing!");
        sc.close();
    }


    private static int playGame(Scanner sc){
        Random random = new Random();
        int secretNumber = random.nextInt( END - START + 1) + START;
        int attempts = 0;
        
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts += 1;
            String result = compareNumbers(secretNumber, guess);
            System.out.println(result);
            if (guess == secretNumber) {
                return attempts;
            }
        }
        System.out.printf("Sorry, you've used all %d attempts, The number was %d.%n", MAX_ATTEMPTS, secretNumber);
        return 0;
    }

    private static String compareNumbers(int secretNumber, int userGuess) {
        if (userGuess < secretNumber) {
            return "Your guess is too low.";
        }else if (userGuess > secretNumber) {
            return "Your guess is too high.";
        }else {
            return "Congratulations! you guessed the number.";
        }
    }
}
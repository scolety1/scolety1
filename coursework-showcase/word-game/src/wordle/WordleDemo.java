package wordle;

import java.util.Scanner;

public class WordleDemo {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wordle game = new Wordle();

        //Set up game display for user
        System.out.println("Welcome to Wordle!");
        System.out.println("Choose difficulty level:");
        System.out.println("1. Easy (8 guesses)");
        System.out.println("2. Normal (6 guesses)");
        System.out.println("3. Hard (4 guesses)");
        int mode = scanner.nextInt();
        game.setDifficulty(mode);

        int attempts = 0; 
        boolean wordGuessed = false;
        	
        //Main loop
        while (attempts < game.getMaxGuesses()) {
        	
            System.out.println("\nEnter your 5-letter guess:");
            String guess = scanner.next();
            
            // Make sure guess is correct
            while (guess.length() != 5) {
                System.out.println("Invalid guess. Please enter a 5-letter word:");
                guess = scanner.next();
            }

            String feedback = game.checkGuess(guess);
            System.out.println(feedback);
            
            // check if guess is correct
            if (feedback.equals("✔️✔️✔️✔️✔️")) {
                wordGuessed = true;
                break;
            }

            attempts++;
        }
        
        // If statement to print results
        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word in " + (attempts + 1) + " attempts.");
        } else {
            System.out.println("Sorry, you've used all your guesses. The word was: " + game.getChosenWord());
        }

        scanner.close();
    }
}

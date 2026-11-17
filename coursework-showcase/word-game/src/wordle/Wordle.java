package wordle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
    private String[] words; // Array to store words from the file
    private String chosenWord; // The randomly chosen word to be guessed
    private int maxGuesses; // Maximum guesses allowed based on the difficulty level

    public Wordle() {
        this.words = readFromFile(); 
        this.chosenWord = selectRandomWord();
    }

    // Reads words from the file and stores them in an array
    private String[] readFromFile() {
        String[] words = new String[549];
        int count = 0;
        try {
            Scanner input = new Scanner(new FileReader("wordle_words.txt"));
            while (input.hasNextLine() && count < words.length) {
                words[count] = input.nextLine().trim().toUpperCase(); // Convert to uppercase to match input
                count++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: Please ensure 'wordle_words.txt' is in the correct directory.");
            e.printStackTrace();
        }
        return Arrays.copyOf(words, count); // Return the array
    }

    // Randomly selects a word
    private String selectRandomWord() {
        Random rand = new Random();
        return words[rand.nextInt(words.length)];
    }

    // Sets the number of guesses based on the difficulty level
    public void setDifficulty(int mode) {
        switch (mode) {
            case 1 -> maxGuesses = 8; // Easy mode
            case 2 -> maxGuesses = 6; // Normal mode
            case 3 -> maxGuesses = 4; // Hard mode
            default -> maxGuesses = 6; // Default to normal if an invalid option is chosen
        }
    }

    // Checks the player's guess against the chosen word and returns feedback as symbols
    public String checkGuess(String guess) {
        StringBuilder feedback = new StringBuilder();

        // Convert guess to uppercase to match the word format
        guess = guess.toUpperCase();

        // Loop through each character
        for (int i = 0; i < 5; i++) {
            char guessed = guess.charAt(i);

            if (guessed == chosenWord.charAt(i)) {
                feedback.append("✔️"); 
            } else if (chosenWord.indexOf(guessed) != -1) {
                feedback.append("🟨"); 
            } else {
                feedback.append("❌");
            }
        }
        return feedback.toString();
    }
    
    // For the Demo class
    public int getMaxGuesses() {
        return maxGuesses;
    }
    
    // For the Demo class
    public String getChosenWord() {
        return chosenWord;
    }
}

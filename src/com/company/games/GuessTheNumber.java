package com.company.games;

import java.util.Scanner;

public class GuessTheNumber {

    public static void guessTheNumber() {
        int randomNumber = (int) (Math.random() * 100 + 1);
        int answer = 0;
        int counter = 1;

        while (answer != randomNumber) {
            System.out.println("Welcome to the \"Guess the Number\" game!");
            System.out.println("Guess a number between the range 1-100:");
            Scanner in = new Scanner(System.in);
            answer = in.nextInt();
            System.out.println(checkGuess(answer, randomNumber, counter));
            counter++;
        }
    }

    public static String checkGuess(int answer, int randomNumber, int counter) {
        if (answer <= 0 || answer > 100) return "Please enter a number in a valid range.";
        else if (answer == randomNumber) return "The guess is correct!\nTotal number of guesses: " + counter;
        else if (answer > randomNumber) return "The number is too high. Please try again!\nNumber of tries: " + counter;
        else if (answer < randomNumber) return "The number is too low. Please try again!\nNumber of tries: " + counter;
        else return "Your guess is incorrect.\nTotal number of guesses: " + counter;
    }
}

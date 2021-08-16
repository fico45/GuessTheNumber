package com.company;

import com.company.apps.WeatherCheck;
import com.company.games.GuessTheNumber;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Select the application you want to run: \n 1) Guess the Number game\n 2) Weather check app\n 9) Exit");
        String msg = in.nextLine();
        int switchGameSelect = Integer.valueOf(msg);
        switch (switchGameSelect) {
            case 1:
                GuessTheNumber.guessTheNumber();
                break;
            case 2:
                WeatherCheck.weatherCheck();
                break;
            case 9:
                break;
        }

    }
}

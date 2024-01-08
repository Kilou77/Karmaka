package com.lo02.Karmaka;

import com.lo02.Karmaka.objects.Game;

import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Main instance;
    private final Scanner scanner = new Scanner(System.in);
    private final Game game;
    private String name;
    private final Random random = new Random();

    private Main() {
        this.game = new Game();
    }

    public static Main getInstance() {
        if (null == instance) {
            instance = new Main();
        }
        return instance;
    }

    public void save() {

    }

    public static void main(String[] args) {
        getInstance().getGame().init();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Game getGame() {
        return game;
    }

    public Random getRandom() {
        return random;
    }
}
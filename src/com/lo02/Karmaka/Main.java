package com.lo02.Karmaka;

import com.lo02.Karmaka.objects.Game;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static Main instance;
    private static final Scanner scanner = new Scanner(System.in);
    private final Game game;
    private String name;


    private Main() {
        this.game = new Game();

    }

    public static Main getInstance() {
        if (null == instance) {
            instance = new Main();
        }
        return instance;
    }

    public static void main(String[] args) {
        getInstance();
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public Game getGame() {
        return game;
    }

    public static Random getRandom() {
        return random;
    }
}
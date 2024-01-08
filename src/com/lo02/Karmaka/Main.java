package com.lo02.Karmaka;

import com.lo02.Karmaka.enums.StateGame;
import com.lo02.Karmaka.objects.Game;

import java.nio.file.Paths;
import java.util.InputMismatchException;
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

    public static void main(String[] args) {
        loadingPage();
        boolean pass = false;
        while (!pass) {
            try{
                String sc = null;
                int choice = -1;
                sc = Main.getInstance().scanner.nextLine();
                choice = Integer.parseInt(sc);
                switch (choice) {
                    case 1:
                        getInstance().getGame().init();
                        pass = true;
                        break;
                    case 2:
                        load();
                        pass = true;
                        break;
                    case 3:
                        System.out.println("Vous avez quitté !");
                        pass = true;
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une option valide.");
                }
            }catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro valide.");
                pass = false;
            }

        }
    }

    private static void loadingPage() {
        System.out.println("****************************************************************************************");
        System.out.println("Bienvenue dans Karmaka !");
        System.out.println("Menu :");
        System.out.println("1 - Jouer");
        System.out.println("2 - Reprendre une partie");
        System.out.println("3 - Quitter");
        System.out.print("Choisissez une option : ");
    }

    public void save() {
        String Path = Paths.get("game.ser").toAbsolutePath().toString();
        game.saveGame(Path);
        System.out.println("Partie sauvegardée.");
    }

    public static void load() {
        String Path = Paths.get("game.ser").toAbsolutePath().toString();
        Game partieChargee = Game.loadGame(Path);
        if (partieChargee != null) {
            System.out.println("Partie chargée depuis : " + Path);
        }else {
            System.out.println("Pas de partie enregistrée");
        }
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
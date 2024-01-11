package com.lo02.Karmaka;

import com.lo02.Karmaka.enums.StateGame;
import com.lo02.Karmaka.objects.Game;

import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe <code>Main</code> est la classe principale du jeu Karmaka.
 * Elle gère l'initialisation du jeu, le chargement de parties, et offre des méthodes utilitaires.
 */
public class Main {
    /** Instance unique de la classe Main (Singleton). */
    private static Main instance;
    /** Création d'un scanner pour la saisie utilisateur. */
    private final Scanner scanner = new Scanner(System.in);
    /** Instance du jeu en cours. */
    private final Game game;
    /** Nom du joueur. */
    private String name;
    /** Générateur de nombres aléatoires notamment pour les cartes . */
    private final Random random = new Random();
    /**
     * Constructeur privé de la classe Main.
     * Initialise l'instance du jeu.
     */
    private Main() {
        this.game = new Game();
    }
    /**
     * Obtient l'instance unique de la classe Main (Singleton).
     *  Crée une instance si aucune est pré-existante.
     * @return L'instance unique de la classe Main.
     */
    public static Main getInstance() {
        if (null == instance) {
            instance = new Main();
        }
        return instance;
    }
    /**
     * Méthode principale, point d'entrée du programme.
     * Affiche la page de chargement, puis le menu principal.
     * Permet de démarrer une nouvelle partie, de reprendre une partie sauvegardée ou de quitter le jeu.
     *
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     */
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
                        getInstance().getGame().setStateGame(StateGame.PLAYING);
                        pass = true;
                        break;
                    case 3:
                        System.out.println("Vous avez quitté !");
                        getInstance().getGame().setStateGame(StateGame.END);
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
    /**
     * Affiche la page de chargement au lancement du jeu avec les différentes possiblitées.
     */
    private static void loadingPage() {
        System.out.println("****************************************************************************************");
        System.out.println("Bienvenue dans Karmaka !");
        System.out.println("Menu :");
        System.out.println("1 - Jouer");
        System.out.println("2 - Reprendre une partie");
        System.out.println("3 - Quitter");
        System.out.print("Choisissez une option : ");
    }
    /**
     * Sauvegarde de la partie en cours dans un fichier sérialisé "game.ser".
     */
    public void save() {
        String Path = Paths.get("game.ser").toAbsolutePath().toString();
        game.saveGame(Path);
        System.out.println("Partie sauvegardée.");
    }
    /**
     * Charge une partie depuis un fichier sérialisé.
     */
    public static void load() {
        String Path = Paths.get("game.ser").toAbsolutePath().toString();
        Game partieChargee = Game.loadGame(Path);
        if (partieChargee != null) {
            System.out.println("Partie chargée depuis : " + Path);
        }else {
            System.out.println("Pas de partie enregistrée");
        }
    }
    /**
     * Obtenir le scanner pour la saisie utilisateur.
     *
     * @return Le scanner de la saisie utilisateur.
     */
    public Scanner getScanner() {
        return scanner;
    }
    /**
     * Obtient l'instance du jeu en cours.
     *
     * @return L'instance du jeu en cours.
     */
    public Game getGame() {
        return game;
    }
    /**
     * Obtient une génération de nombres aléatoires.
     *
     * @return Une génération de nombres aléatoires.
     */
    public Random getRandom() {
        return random;
    }
}
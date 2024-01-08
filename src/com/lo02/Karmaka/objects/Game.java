package com.lo02.Karmaka.objects;


import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Card;
import com.lo02.Karmaka.cards.Stack;
import com.lo02.Karmaka.enums.StateGame;
import com.lo02.Karmaka.enums.Strategy;

import java.io.*;

public class Game {
    private Player player1;
    private Player player2;
    private Player activePlayer;
    private StateGame stateGame;
    private Stack well;
    private Stack ruins;
    private CardManager cardManager = new CardManager();

    public void init() {
        // Initialisation de la partie
        stateGame = StateGame.INIT;
        System.out.println("************************* Initialisation de la partie *************************");
        boolean pass = false;
        String sc = null;
        while (!pass) {
            System.out.println("Veuillez choisir les joueurs ");
            System.out.println("1 : 2 Joueurs réels");
            System.out.println("2 : 1 Joueurs réel et un Joueur virtuel");
            //System.out.println("3 : 2 Joueurs virtuels");
            sc = Main.getInstance().getScanner().nextLine();
            int choice = Integer.parseInt(sc);
            if (choice >= 1 && choice <= 3) {
                switch (sc) {
                    case "1" -> {
                        this.player1 = new Player();
                        this.player2 = new Player();
                        pass = true;
                    }
                    case "2" -> {
                        this.player1 = new Player();

                        // Choose the strategy of the bot
                        boolean pass1 = false;
                        while (!pass1) {
                            System.out.println("Veuillez choisir la stratégie du bot : ");
                            System.out.println("1 : Bot Offensif");
                            System.out.println("2 : Bot Defensif");
                            System.out.println("3 : Bot Random");
                            sc = Main.getInstance().getScanner().nextLine();
                            int choice1 = Integer.parseInt(sc);
                            if (choice1 >= 1 && choice <= 3) {
                                switch (sc) {
                                    case "1" -> {
                                        this.player2 = new VirtualPlayer(Strategy.OFFENSIVE);
                                        pass1 = true;
                                    }
                                    case "2" -> {
                                        this.player2 = new VirtualPlayer(Strategy.DEFENSIVE);

                                        pass1 = true;
                                    }
                                    case "3" -> {
                                        this.player2 = new VirtualPlayer(Strategy.RANDOM);
                                        pass1 = true;
                                    }
                                }
                            } else {
                                System.out.println("Choix invalide.Veuillez choisir une autre configuration");
                                pass = false;
                            }
                        }
                        pass = true;
                    }
                   /* case "3" -> {
                        this.player1 = new VirtualPlayer();
                        this.player2 = new VirtualPlayer();
                        pass = true;
                    } */
                }
            } else {
                System.out.println("Choix invalide.Veuillez choisir une autre configuration");
                pass = false;
            }
        }
        this.well = new Stack();
        this.ruins = new Stack();
        this.cardManager.init();
        if (well.getCards().size() < 12) {
            System.out.println("NON");
            return;
        }
        for (int i = 0; i < 4; i++) {
            player1.getHand().add(well.takeCard());
            player2.getHand().add(well.takeCard());
        }
        for (int i = 0; i < 2; i++) {
            player1.getDeck().addCard(well.takeCard());
            player2.getDeck().addCard(well.takeCard());
        }
        start();
    }

    public void start() {
        stateGame = StateGame.PLAYING;
        System.out.println("************************* Début de la partie de Karmaka *************************");
        activePlayer = (Main.getInstance().getRandom().nextInt(2) == 1) ? player1 : player2;
        while (true) {
            //TOUR
            System.out.println("****************************************************************************************");
            activePlayer.playTurn();
            //Fin du tour, changement de joueur
            this.activePlayer = (activePlayer == player1) ? player2 : player1;
        }


    }

    public void saveGame(String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(this);
            System.out.println("Partie sauvegardée avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la sauvegarde de la partie.");
        }
    }

    public static Game loadGame(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Game partie = (Game) ois.readObject();
            System.out.println("Partie chargée avec succès.");
            return partie;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Erreur lors du chargement de la partie.");
            return null;
        }
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void end() {
        stateGame = StateGame.END;
    }

    public StateGame getStateGame() {
        return stateGame;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public CardManager getCardManager() {
        return cardManager;
    }

    public Stack getRuins() {
        return ruins;
    }


    public Stack getWell() {
        return well;
    }

    public void showRuins(int n) {
        StringBuilder txt = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            txt.append(" ").append(i).append(") ").append(getRuins().getCards().get(i).getName());
        }
        System.out.println("Les" + n + "premières cartes de la ruine sont : " + txt);
    }

    public void showWell(int n) {
        StringBuilder txt = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            txt.append(" ").append(i).append(") ").append(getWell().getCards().get(i).getName());
        }
        System.out.println("Les" + n + "premières cartes de la source sont : " + txt);
    }
}

package com.lo02.Karmaka.objects;


import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Card;
import com.lo02.Karmaka.cards.Stack;

public class Game {
    private Player player1;
    private Player player2;
    private Player activePlayer;
    private static Stack well;
    private Stack ruins;
    private CardManager cardManager = new CardManager();



    public void init() {
        // Initialisation de la partie
        this.player1 = new Player();
        this.player2 = new Player();
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
        activePlayer = (Main.getRandom().nextInt(2) == 1) ? player1 : player2;
        while (true) {
            //TOUR
            System.out.println("****************************************************************************************");
            activePlayer.playTurn();
            //Fin du tour, changement de joueur
            this.activePlayer = (activePlayer==player1) ? player2 : player1;
        }


    }
    public void end() {

    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public static Stack getWell() {
        return well;
    }
}

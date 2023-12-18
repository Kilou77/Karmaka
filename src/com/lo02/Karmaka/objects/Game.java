package com.lo02.Karmaka.objects;


import com.lo02.Karmaka.cards.Stack;

public class Game {
    private Player player1;
    private Player player2;
    private Player activePlayer;
    private Stack well;
    private Stack ruins;
    private CardManager cardManager = new CardManager();



    public void init() {
        // Initialisation de la partie
        this.player1 = new Player();
        this.player2 = new Player();
        this.well = new Stack();
        this.ruins = new Stack();
        start();
    }

    public void start() {
        activePlayer = (Main.getRandom().nextInt(2) == 1) ? player1 : player2;
        while (true) {
            //TOUR
            activePlayer.playTurn();

            //Fin du tour, changement de joueur
            this.activePlayer = (activePlayer==player1) ? player2 : player1;
        }


    }

    public void end() {

    }
}

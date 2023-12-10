package com.lo02.Karmaka.objects;


import com.lo02.Karmaka.cards.Stack;

public class Game {
    private Player player1;
    private Player player2;
    private Player activePlayer;
    private Stack well;
    private Stack ruins;


    public Game(){
        init();
    }
    public void save(){

    }
    public void start(){


    }
    public void end(){

    }
    public void init(){
        this.player1 = new Player();
        this.player2 = new Player();
        this.well = new Stack();
        this.ruins = new Stack();
    }
}

package com.lo02.Karmaka;

import java.util.List;
import java.util.Scanner;

class Player {
    private String name;
    private List<Cards> futureLife;
    private List<Cards> hand;
    private enum karmicScale{dunk, beetle, snake, wolf, ape, transcendence};
    private int karmicRing;
    public Player(){
        String sc = String.valueOf(new Scanner(System.in));
        this.name = sc;
    }
    public void playTurn(){

    }

    public void reborn(){

    }
}

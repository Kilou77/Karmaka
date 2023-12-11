package com.lo02.Karmaka.objects;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Cards;
import com.lo02.Karmaka.cards.Stack;
import com.lo02.Karmaka.enums.KarmicScale;

import java.util.ArrayList;
import java.util.List;


class Player {
    private String name;
    private final Stack futureLife;
    private final Stack hand;
    private int karmicRing;
    private KarmicScale karmicScale;
    public Player(){
        askname();
        this.karmicScale = KarmicScale.DUNG_BEETLE;
        this.futureLife = new Stack();
        this.hand = new Stack();
        this.karmicRing = 0;
    }
    public void askname(){
        String sc = null;
        while (sc == null){
            System.out.println("Veuillez entrer le nom du joueur => ");
            sc = Main.getScanner().nextLine();
        }
        this.name = sc;
    }
    public void playTurn(){

    }

    public void reborn(){

    }
}

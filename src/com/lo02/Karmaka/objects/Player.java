package com.lo02.Karmaka.objects;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Cards;

import java.util.List;


class Player {
    private String name;
    private List<Cards> futureLife;
    private List<Cards> hand;
    private int karmicRing;
    public Player(){
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

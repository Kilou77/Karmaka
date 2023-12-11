package com.lo02.Karmaka.objects;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Cards;
import com.lo02.Karmaka.enums.KarmicScale;

import java.util.ArrayList;
import java.util.List;


class Player {
    private String name;
    private List<Cards> futureLife;
    private List<Cards> hand;
    private int karmicRing;
    private KarmicScale karmicScale;
    public Player(){
        String sc = null;
                while (sc == null){
                    System.out.println("Veuillez entrer le nom du joueur => ");
                    sc = Main.getScanner().nextLine();
                }
        this.name = sc;
        this.karmicScale = KarmicScale.DUNG_BEETLE;
        this.futureLife = new ArrayList<Cards>();
        this.hand = new ArrayList<Cards>();
        this.karmicRing = 0;
    }
    public void playTurn(){

    }

    public void reborn(){

    }
}

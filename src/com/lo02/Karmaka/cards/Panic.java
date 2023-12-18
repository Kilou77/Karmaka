package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;

public class Panic extends Card {

    public Panic() {
        super("Panique", 1, Color.RED, "Défaussez la première carte de la Pile d'un joueur. Vous pouvez ensuite jouer une autre carte.");
    }

    @Override
    public void activate() {
        //TODO
        //action of the card
    }
}

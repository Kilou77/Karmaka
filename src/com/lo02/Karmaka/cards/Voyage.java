package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;

public class Voyage extends Card {

    public Voyage() {
        super("Voyage", 3, Color.BLUE, "Puisez 3 cartes à la Source. Vous pouvez ensuite jouer une autre carte.");
    }

    @Override
    public void activate() {
        //TODO
        //action of the card
    }
}

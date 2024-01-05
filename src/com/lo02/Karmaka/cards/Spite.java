package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Spite extends Card {

    public Spite() {
        super("Vengeance", 3, Color.RED, "Défaussez au hasard 2 cartes de la Main d’un rival.");
    }

    @Override
    public void activate(Player player) {
        //TODO
        //action of the card
    }
}

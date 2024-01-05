package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Panic extends Card {

    public Panic() {
        super("Panique", 1, Color.RED, "Défaussez la première carte de la Pile d'un joueur. Vous pouvez ensuite jouer une autre carte.");
    }

    @Override
    public void activate(Player player) {
        //TODO
        //action of the card
    }
}

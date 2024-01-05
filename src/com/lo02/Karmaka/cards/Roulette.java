package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Roulette extends Card {

    public Roulette() {
        super("Roulette", 1, Color.RED, "Défaussez jusqu’à 2 cartes de votre Main. Vous pouvez ensuite puiser à la Source autant de carte(s) + 1.");
    }

    @Override
    public void activate(Player player) {
        //TODO
        //action of the card
    }
}

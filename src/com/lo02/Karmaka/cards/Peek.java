package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Peek extends Card {

    public Peek() {
        super("Coup d'Oeil", 1, Color.BLUE,"");
    }

    @Override
    public void activate(Player player) {
        System.out.println("Voici la main du rival.");
        player.getOtherPlayer().showHand();
        System.out.println("Choisissez une de ces cartes.");
        player.playCard();
    }
}


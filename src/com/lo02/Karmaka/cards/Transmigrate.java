package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Transmigrate extends Card {

    public Transmigrate() {
        super("Transmigration", 1, Color.BLUE,"Placez dans votre Main n’importe quelle carte de votre Vie Future.");
    }

    @Override
    public void activate(Player player) {
        player.showFutureLife();
        player.getHand().add(player.getFutureLife().pickCard());
    }
}


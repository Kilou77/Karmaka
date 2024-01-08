package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Sowing extends Card {

    public Sowing() {
        super("Semis", 2, Color.GREEN, "Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main.");
    }

    @Override
    public void activate(Player player) {
        player.drawWell();
        player.drawWell();
        player.getFutureLife().addCard(player.getHand().get(Main.getInstance().getRandom().nextInt(player.getHand().size())));
        player.getFutureLife().addCard(player.getHand().get(Main.getInstance().getRandom().nextInt(player.getHand().size())));
    }
}

package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Game;
import com.lo02.Karmaka.objects.Player;

public class Vengeance extends Card {

    public Vengeance() {
        super("Vengeance", 3, Color.RED, "Défaussez l’Oeuvre Exposée d’un rival.");
    }

    @Override
    public void activate(Player player) {
        Game.getRuins().addCard(player.getOtherPlayer().getDeeds().getCards().getFirst());
    }
}

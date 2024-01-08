package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Game;
import com.lo02.Karmaka.objects.Player;

public class HellsHeart extends Card {

    public HellsHeart() {
        super("Fournaise", 2, Color.RED, "Défaussez les 2 premières cartes de la Vie Future d'un rival.");
    }

    @Override
    public void activate(Player player) {
        Main.getInstance().getGame().getRuins().addCard(player.getOtherPlayer().getFutureLife().takeCard());
        Main.getInstance().getGame().getRuins().addCard(player.getOtherPlayer().getFutureLife().takeCard());
    }
}

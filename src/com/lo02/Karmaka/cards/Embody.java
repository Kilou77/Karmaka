package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Embody extends Card {

    public Embody() {
        super("Incarnation", 1, Color.MOSAIC, "Choisissez une de vos Oeuvres. Copiez son pouvoir.");
    }

    @Override
    public void activate(Player player) {
        player.getDeeds().showStack();
    }
}

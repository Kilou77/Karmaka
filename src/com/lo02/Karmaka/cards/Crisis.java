package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Crisis extends Card {

    public Crisis() {
        super("Crise", 2, Color.RED, "Le rival de votre choix défausse une de ses Oeuvres.");
    }

    @Override
    public void activate(Player player) {
        //TODO
        //action of the card
    }
}

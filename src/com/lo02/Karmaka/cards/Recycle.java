package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Recycle extends Card {

    public Recycle() {
        super("Recyclage", 1, Color.GREEN, "Ajoutez à votre Vie Future une des 3 dernières cartes de la Fosse.");
    }

    @Override
    public void activate(Player player) {

    }
}

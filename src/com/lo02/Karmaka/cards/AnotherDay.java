package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class AnotherDay extends Card {

    public AnotherDay() {
        super("Lendemain", 1, Color.GREEN, "Puisez une carte à la Source. Vous pouvez ensuite jouer une autre carte.");
    }

    @Override
    public void activate(Player player) {
        //TODO
        //action of the card
    }
}

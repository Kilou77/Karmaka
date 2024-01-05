package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Dwindle extends Card {

    public Dwindle() {
        super("Dernier Souffle", 1, Color.RED, "Le joueur de votre choix défausse une carte de sa Main.");
    }

    @Override
    public void activate(Player player) {
        //TODO
        //action of the card
    }
}

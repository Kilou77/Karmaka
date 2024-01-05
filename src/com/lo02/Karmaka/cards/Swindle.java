package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Swindle extends Card {

    public Swindle() {
        super("Duperie", 3, Color.BLUE, "Regardez 3 cartes de la Main d’un rival. Ajoutez-en une à votre Main.");
    }

    @Override
    public void activate(Player player) {
        //TODO
        //action of the card
    }
}

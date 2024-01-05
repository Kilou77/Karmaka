package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Salvage extends Card {

    public Salvage() {
        super("Sauvetage", 2, Color.GREEN, "Ajoutez à votre Main une des3 dernières cartes de la Fosse.");
    }

    @Override
    public void activate(Player player) {
        //TODO
        //action of the card
    }
}

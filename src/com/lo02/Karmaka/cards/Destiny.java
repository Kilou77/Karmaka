package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Destiny extends Card {

    public Destiny() {
        super("Destinée", 2, Color.BLUE, "Regardez les 3 premières cartes de la Source ; ajoutez-en jusqu’à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.");
    }

    @Override
    public void activate(Player player) {
        //TODO
        //action of the card
    }
}

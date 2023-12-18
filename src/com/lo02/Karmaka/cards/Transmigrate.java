package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;

public class Transmigrate extends Card {

    public Transmigrate() {
        super("Transmigration", 1, Color.BLUE,"Placez dans votre Main n’importequelle carte de votre Vie Future.");
    }

    @Override
    public void activate() {
        System.out.println("Placez dans notre Main n'importe quelle carte de votre Vie Future.");
        //TODO
        //action of the card
    }
}


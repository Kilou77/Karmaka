package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;

public class Transmigrate extends Cards {

    public Transmigrate(){
        super("Transmigration",1, Color.BLUE);
    }

    @Override
    public void activate() {
        System.out.println("Take any card from your Future Life into your Hand.");
        //TODO
        //action of the card
    }
}


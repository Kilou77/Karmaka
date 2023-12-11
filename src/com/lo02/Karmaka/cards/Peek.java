package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;

public class Peek extends Cards {

    public Peek(){
        super("Coup d'Oeil",1, Color.BLUE);
    }

    @Override
    public void activate() {
        System.out.println("Look at a rival's Hand. You may then play another card.");
        //TODO
        //action of the card
    }
}


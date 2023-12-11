package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;

public abstract class Cards {
    private final String name;
    private final int points;

    private final Color color;

    public Cards(String name, int value, Color color){
        this.name = name;
        this.points = value;
        this.color = color;
    }
    public abstract void activate();

    public void playForPoints(){

    }
    public void playFutureLife(){

    }
}

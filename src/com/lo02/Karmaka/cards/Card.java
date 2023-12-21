package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public abstract class Card {
    private final String name;
    private final int points;
    private final String description;
    private final Color color;

    public Card(String name, int value, Color color, String description) {
        this.name = name;
        this.points = value;
        this.color = color;
        this.description = description;
    }

    public abstract void activate();

    public void playForPoints(Player player) {
        if (player.getHand().contains(this)){
            player.getHand().remove(this);
            player.getDeeds().addCard(this);
        }
    }

    public void playFutureLife(Player player) {
        if (player.getHand().contains(this)){
            player.getHand().remove(this);
            player.getFutureLife().addCard(this);
        }
    }

    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }

    public int getPoints() {
        return points;
    }

    public Color getColor() {
        return color;
    }
}

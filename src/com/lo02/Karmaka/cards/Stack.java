package com.lo02.Karmaka.cards;

import java.util.ArrayList;

public class Stack {
    private final ArrayList<Card> cards;

    public Stack() {
        this.cards = new ArrayList<>();
    }
    public void addCards(Cards card){
        cards.add(card);
    }
    public Cards takeCards(){
        Cards card = cards.getFirst();
        cards.remove(card);
        return card;
    }
}

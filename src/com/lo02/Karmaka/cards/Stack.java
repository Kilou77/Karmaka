package com.lo02.Karmaka.cards;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private final ArrayList<Card> cards;

    public Stack() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> takeCards(int number) {
        List<Card> cardsPick = new ArrayList<>();
        for (int i = 0; i < number ; i++){
            Card card = cards.getFirst();
            cards.remove(card);
            cardsPick.add(card);
        }
        return cardsPick;
    }

    public Card takeCard() {
        Card card = cards.getFirst();
        cards.remove(card);
        return card;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}

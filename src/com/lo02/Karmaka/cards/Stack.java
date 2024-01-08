package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;

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

    public Card pickCard() {
        String sc = null;
        Card c = null;
        boolean pass = false;
        while (c == null || pass) {
            System.out.println("Veuillez choisir le numéro associé à la carte présente dans votre main : ");
            sc = Main.getInstance().getScanner().nextLine();
            c = this.cards.get(Integer.parseInt(sc));
        }
        this.cards.remove(c);
        return c;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}

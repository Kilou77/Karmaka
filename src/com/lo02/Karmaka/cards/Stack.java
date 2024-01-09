package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.objects.Player;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private final ArrayList<Card> cards;
    private String name;

    public Stack(String name) {
        this.cards = new ArrayList<>();
        this.name = name;
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
    // draw a card in any stack
    public void drawCard(Stack stack) {
        if (!cards.isEmpty()) {
            Card c = takeCard();
            stack.addCard(c);
            System.out.println("Vous avez pioché la carte : " + c.getName() + " dans votre pile. Elle sera placée en dernière position dans votre pile "+ stack.getName());
        } else {
                System.out.println("Votre pile est vide, par conséquent, vous n'avez pas pioché");
        }
    }

    public Card pickCard() {
        Card c = null;
        boolean pass = false;
        while (c == null || pass) {
            showStack();
            String sc = null;

            try {
                System.out.println("Veuillez choisir le numéro associé à la carte présente dans votre pile " + this.getName() + " : ");
                sc = Main.getInstance().getScanner().nextLine();
                int cardNumber = Integer.parseInt(sc);

                // Verification of the card
                if (cardNumber >= 0 && cardNumber < cards.size()) {
                    c = cards.get(cardNumber);

                    //Description of the card
                    System.out.print("Voici la description de la carte : ");
                    System.out.println(c.getName() + " : " + c.getDescription());

                    System.out.println("Etes-vous sûr d'utiliser cette carte ? O/n ");
                    sc = Main.getInstance().getScanner().nextLine();

                    if (sc.equalsIgnoreCase("O")) {


                    } else if (sc.equalsIgnoreCase("n")) {
                        System.out.println("Veuillez choisir une autre carte");
                        c = null;
                    } else {
                        System.out.println("Mauvaise entrée, veuillez recommencer svp");
                        c = null;
                    }
                } else {
                    System.out.println("Numéro de carte invalide. Veuillez choisir un numéro valide.");
                    c = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro valide.");
                sc = null;
            }
        }

        return c;
    }
    public void showStack() {
        // show what is in the active player's hand
        StringBuilder txt = new StringBuilder();
        if(!cards.isEmpty()){
            for (Card card : cards) {
                txt.append(" ").append(cards.indexOf(card)).append(") ").append(card.getName());
            }
            System.out.println("Votre pile " + this.getName() + " est composée de : " + txt);
        }else{
            System.out.println("Votre pile est vide");
        }

    }
    public ArrayList<Card> getCards() {
        return cards;
    }
    public String getName() {
        return name;
    }
}

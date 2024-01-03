package com.lo02.Karmaka.objects;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Card;
import com.lo02.Karmaka.cards.Stack;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.enums.KarmicScale;

import java.util.List;
import java.util.ArrayList;

public class Player {
    private final Stack futureLife;
    private final Stack deeds;
    private final List<Card> hand;
    private final Stack deck;
    private String name;
    private int karmicRing;
    private KarmicScale karmicScale;

    public Player() {
        askName();
        this.karmicScale = KarmicScale.DUNG_BEETLE;
        this.futureLife = new Stack();
        this.deeds = new Stack();
        this.hand = new ArrayList<>();
        this.karmicRing = 0;
        this.deck = new Stack();
    }

    public void askName() {
        String sc = null;
        while (sc == null) {
            System.out.println("Veuillez entrer le nom du joueur => ");
            sc = Main.getScanner().nextLine();
        }
        this.name = sc;
        sc = null;
    }

    public void playTurn() {
        StringBuilder txt = new StringBuilder();
        for (Card card : hand) {
            txt.append(" ").append(hand.indexOf(card)).append(") ").append(card.getName());
        }
        System.out.println("C'est votre tour " + name + " !");
        System.out.println("Votre main est composée de : " + txt);

        if (!deck.getCards().isEmpty()) {
            Card c = deck.takeCard();
            hand.add(c);
            System.out.println("Vous avez pioché la carte : " + c.getName() + " dans la Source.");
        } else {
            if (hand.isEmpty()) {
                reborn();
                return;
            } else {
                System.out.println("Votre pile est vide, par conséquent, vous n'avez pas pioché");
            }
        }
        Card c = null;
        boolean pass = false;
        while (c == null || pass) {
            //TODO
            String sc = null;
            System.out.println("Veuillez choisir le numéro associé à la carte présente dans votre main : ");
            sc = Main.getScanner().nextLine();
            c = hand.get(Integer.parseInt(sc));
            System.out.print("Voici la description de la carte: ");
            System.out.println(c.getName() + " : " + c.getDescription());
            System.out.println("Etes vous sûr de jouer cette carte ? O/n ");
            String test = null;
            while (!(test == "1")){
                sc = Main.getScanner().nextLine();
                if (sc.equals("O")|| sc.equals("o")) {
                    System.out.println("1 : Jouer cette carte pour les points");
                    System.out.println("2 : Jouer cette carte pour son pouvoir");
                    System.out.println("3 : Garder cette carte pour sa prochaine vie");
                    System.out.println("4 : Défausser cette carte");
                    sc = null;
                    sc = Main.getScanner().nextLine();
                    switch (sc) {
                        case "1" -> c.playForPoints(this);
                        case "2" -> c.activate();
                        case "3" -> c.playFutureLife(this);
                        case "4" -> {
                            hand.remove(c);
                            System.out.println("La carte " + c.getName() + " a été défaussée de votre main");
                        }
                    }
                    test ="1";
                } else if (sc.equals("N") || sc.equals("n")){
                    System.out.println("Veuillez choisir une autre carte");
                    sc = null;
                }
                else if(!sc.equals("O")|| !sc.equals("o")||!sc.equals("N")||!sc.equals("n") ){
                    System.out.println("Mauvaise entrée, veuillez recommencer svp");
                    sc = null;
                }
            }


            //Faire choisir une carte à l'utilisateur
            //Donner la description
            //Lui demander confirmation de l'utilisation ou remettre c à null
            // proposer sauvegarde
            // gestion des exceptions pour le scanner
        }
    }

    public void reborn() {
        int redPoints = 0;
        int bluePoints = 0;
        int greenPoints = 0;
        int mosaicPoints = 0;
        for (Card card : deeds.getCards()) {
            switch (card.getColor()) {
                case RED -> redPoints += card.getPoints();
                case BLUE -> bluePoints += card.getPoints();
                case GREEN -> greenPoints += card.getPoints();
                case MOSAIC -> {
                    redPoints += card.getPoints();
                    bluePoints += card.getPoints();
                    greenPoints += card.getPoints();
                }
            }
        }
        int maxPoints = Math.max(redPoints, Math.max(bluePoints, greenPoints));
        int karmicLevel = karmicScale.getValue();

        if (maxPoints > karmicLevel) {
            this.karmicScale = KarmicScale.values()[karmicScale.ordinal() + 1];
        } else {
            this.karmicRing++;
        }
    }

    public List<Card> getHand() {
        return hand;
    }

    public Stack getDeck() {
        return deck;
    }

    public Stack getDeeds() {
        return deeds;
    }

    public Stack getFutureLife() {
        return futureLife;
    }

}
package com.lo02.Karmaka.objects;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Card;
import com.lo02.Karmaka.cards.Stack;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.enums.KarmicScale;
import com.lo02.Karmaka.objects.Game;

import java.util.List;
import java.util.ArrayList;

import static com.lo02.Karmaka.cards.Stack.*;

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

    public void drawCard() {
        if (!deck.getCards().isEmpty()) {
            Card c = deck.takeCard();
            hand.add(c);
            System.out.println("Vous avez pioché la carte : " + c.getName() + " dans votre pile. Elle sera placée en dernière position dans votre main.");
        } else {
            if (hand.isEmpty()) {
                reborn();
                return;
            } else {
                System.out.println("Votre pile est vide, par conséquent, vous n'avez pas pioché");
            }
        }
    }

    public void drawWell() {
        Card c = Game.getWell().takeCard();
        hand.add(c);
        System.out.println("Vous avez pioché la carte: " + c.getName() + " dans la source");
    }

    public void playCard() {
        Card c = null;
        c = playerPick();
        boolean pass1 = false;
        String sc = null;

        while(!pass1){
            System.out.println("Veuillez choisir une action : ");
            System.out.println("1 : Jouer cette carte pour les points");
            System.out.println("2 : Jouer cette carte pour son pouvoir");
            System.out.println("3 : Garder cette carte pour sa prochaine vie");
            System.out.println("4 : Défausser cette carte");
            sc = Main.getScanner().nextLine();
            int cardNumber = Integer.parseInt(sc);
            if (cardNumber >= 1 && cardNumber <= 4) {
                switch (sc) {
                    case "1" -> {
                        c.playForPoints(this);
                        pass1 = true;
                    }
                    case "2" -> {
                        c.activate(this);
                        pass1 = true;
                    }
                    case "3" -> {
                        c.playFutureLife(this);
                        pass1 = true;
                    }
                    case "4" -> {
                        hand.remove(c);
                        System.out.println("La carte " + c.getName() + " a été défaussée de votre main");
                        pass1 = true;
                    }
                    default -> {
                        System.out.println("Choix invalide. Veuillez choisir une action à réaliser");
                    }
                }
            } else {
                System.out.println("Choix invalide. La carte n'a pas été jouée. Veuillez choisir une action à réaliser");
                pass1 = false;
            }
        }


    }

    public void playTurn() {
        System.out.println("C'est votre tour " + name + " !");
        drawCard(); //Fait piocher une carte à l'utilisateur depuis sa pile
        playCard(); //Fait jouer la carte de son choix à l'utilisateur
        // proposer sauvegarde
    }

    public void showHand() {
        // show what is in the active player's hand
        StringBuilder txt = new StringBuilder();
        for (Card card : hand) {
            txt.append(" ").append(hand.indexOf(card)).append(") ").append(card.getName());
        }
        System.out.println("Votre main est composée de : " + txt);
    }

    public void showDeeds() {
        // show what is in the active player's deeds
        StringBuilder txt = new StringBuilder();
        for (Card card : deeds.getCards()) {
            txt.append(" ").append(deeds.getCards().indexOf(card)).append(") ").append(card.getName());
        }
        System.out.println("Vous disposez des oeuvres suivantes : " + txt);
    }

    public void showFuturLife(){
        // show what is in the active player's deeds
        StringBuilder txt = new StringBuilder();
        for (Card card : futureLife.getCards()) {
            txt.append(" ").append(futureLife.getCards().indexOf(card)).append(") ").append(card.getName());
        }
        System.out.println("Vous disposez des oeuvres suivantes : " + txt);
    }

    public Card playerPick(){
        Card c = null;
        boolean pass = false;
        while (c == null || pass) {
            showHand();
            String sc = null;

            try {
                System.out.println("Veuillez choisir le numéro associé à la carte présente dans votre main : ");
                sc = Main.getScanner().nextLine();
                int cardNumber = Integer.parseInt(sc);

                // Verification of the card
                if (cardNumber >= 0 && cardNumber < hand.size()) {
                    c = hand.get(cardNumber);

                    //Description of the card
                    System.out.print("Voici la description de la carte : ");
                    System.out.println(c.getName() + " : " + c.getDescription());

                    System.out.println("Etes-vous sûr de jouer cette carte ? O/n ");
                    sc = Main.getScanner().nextLine();

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

    public Player getOtherPlayer() {
        Game game = Main.getInstance().getGame();
        return (game.getPlayer1() == this) ? game.getPlayer2() : game.getPlayer1();
    }

}
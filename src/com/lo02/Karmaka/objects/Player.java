package com.lo02.Karmaka.objects;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Card;
import com.lo02.Karmaka.cards.Stack;
import com.lo02.Karmaka.enums.KarmicScale;

import java.util.List;


class Player {
    private String name;
    private final Stack futureLife;
    private final Stack hand;
    private int karmicRing;
    private KarmicScale karmicScale;
    public Player(){
        askname();
        this.karmicScale = KarmicScale.DUNG_BEETLE;
        this.futureLife = new Stack();
        this.hand = new Stack();
        this.karmicRing = 0;
    }
    public void askname(){
        String sc = null;
        while (sc == null) {
            System.out.println("Veuillez entrer le nom du joueur => ");
            sc = Main.getScanner().nextLine();
        }
        this.name = sc;
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
            System.out.println("Vous avez piocher une carte : " + c.getName());
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
            System.out.println("Veuillez choisir le numéro associé à la carté présente dans votre main : ");
            sc = Main.getScanner().nextLine();
            if(hand.indexOf(c) == Integer.parseInt(sc) ){
                c = hand.get(Integer.parseInt(sc));
                System.out.println("Voici la description de la carte. Etes vous sûr OUI/NON?");
                System.out.println(c.getName() + "et le description est la suivante :" + c.getDescription());
                if(sc.equals("OUI")){

                }
            }

            //Faire choisir une carte à l'utilisateur
            //Donner la description
            //Lui demander confirmation de l'utilisation ou remettre c à null
            // proposer sauvegarde



        }
    }

    public void reborn() {

    }
}

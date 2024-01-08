package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Jubilee extends Card {

    public Jubilee() {
        super("Jubilé", 3, Color.GREEN, "Placez jusqu’à 2 cartes de votre Main sur vos Oeuvres.");
    }

    @Override
    public void activate(Player player) {
        player.showHand();
        System.out.println("Combien de cartes voulez vous mettre sur vos Oeuvres ? (2 max)");
        Card c = null;
        int max = 2;
        String sc = null;
        sc = Main.getInstance().getScanner().nextLine();
        if (Integer.parseInt(sc) <= 2 && Integer.parseInt(sc) > 0) {
            for (int i = 1; i <= Integer.parseInt(sc); i++) {
                player.showHand();
                player.getDeeds().addCard(player.playerPick());
            }
        } else if (Integer.parseInt(sc) > 2) {
            System.out.println("Entrée invalide. Veuillez recommencer.");
            activate(player);
        }
    }
}

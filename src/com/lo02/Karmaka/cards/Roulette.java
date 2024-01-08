package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Game;
import com.lo02.Karmaka.objects.Player;

public class Roulette extends Card {

    public Roulette() {
        super("Roulette", 1, Color.RED, "Défaussez jusqu’à 2 cartes de votre Main. Vous pouvez ensuite puiser à la Source autant de carte(s) + 1.");
    }

    @Override
    public void activate(Player player) {
        System.out.println("Combien de cartes voulez vous défausser ? (2 max)");
        Card c = null;
        int max = 2;
        String sc = null;
        sc = Main.getInstance().getScanner().nextLine();
        if (Integer.parseInt(sc) <= 2 && Integer.parseInt(sc) > 0) {
            for (int i = 1; i <= Integer.parseInt(sc); i++) {
                player.showHand();
                Main.getInstance().getGame().getRuins().addCard(player.playerPick());
            }
            for (int i = 1; i <= Integer.parseInt(sc) + 1; i++) {
                player.drawWell();
            }
        } else if (Integer.parseInt(sc) > 2) {
            System.out.println("Entrée invalide. Veuillez recommencer.");
            activate(player);
        }
    }
}

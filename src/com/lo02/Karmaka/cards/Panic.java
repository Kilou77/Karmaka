package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Game;
import com.lo02.Karmaka.objects.Player;

public class Panic extends Card {

    public Panic() {
        super("Panique", 1, Color.RED, "Défaussez la première carte de la Pile d'un joueur. Vous pouvez ensuite jouer une autre carte.");
    }

    @Override
    public void activate(Player player) {
        System.out.println("Choisissez un joueur : 1 pour vous, 2 pour l'adversaire");
        String sc = Main.getInstance().getScanner().nextLine();
        switch (sc) {
            case "1" -> Main.getInstance().getGame().getRuins().addCard(player.getDeck().getCards().getFirst());
            case "2" -> Main.getInstance().getGame().getRuins().addCard(player.getOtherPlayer().getDeck().getCards().getFirst());
            default -> {
                System.out.println("Veuillez rentrer une saisie valide.");
                activate(player);
            }
        }
    }
}

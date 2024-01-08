package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Game;
import com.lo02.Karmaka.objects.Player;

public class Longevity extends Card {

    public Longevity() {
        super("Longevité", 2, Color.GREEN, "Placez 2 cartes puisées à la Source sur la Pile d'un joueur.");
    }

    @Override
    public void activate(Player player) {
        System.out.println("Choisissez un joueur : 1 pour vous, 2 pour l'adversaire");
        String sc = Main.getInstance().getScanner().nextLine();
        switch (sc) {
            case "1" -> {
                player.getDeck().addCard(Main.getInstance().getGame().getWell().takeCard());
                player.getDeck().addCard(Main.getInstance().getGame().getWell().takeCard());
            }
            case "2" -> {
                player.getOtherPlayer().getDeck().addCard(Main.getInstance().getGame().getWell().takeCard());
                player.getOtherPlayer().getDeck().addCard(Main.getInstance().getGame().getWell().takeCard());
            }
            default -> {
                System.out.println("Veuillez rentrer une saisie valide.");
                activate(player);
            }
        }
    }
}

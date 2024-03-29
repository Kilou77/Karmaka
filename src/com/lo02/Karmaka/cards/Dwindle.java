package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Game;
import com.lo02.Karmaka.objects.Player;
import com.lo02.Karmaka.cards.Stack;

import java.util.Scanner;

public class Dwindle extends Card {

    public Dwindle() {
        super("Dernier Souffle", 1, Color.RED, "Le joueur de votre choix défausse une carte de sa Main.");
    }

    @Override
    public void activate(Player player) {
        System.out.println("Choisissez un joueur : 1 pour vous, 2 pour l'adversaire");
        String sc = Main.getInstance().getScanner().nextLine();
        switch (sc) {
            case "1" ->{
                player.getFutureLife().showStack();
                Main.getInstance().getGame().getRuins().addCard(player.getHand().get(Main.getInstance().getRandom().nextInt(player.getHand().size())));
            }
            case "2" -> Main.getInstance().getGame().getRuins().addCard(player.getOtherPlayer().getHand().get(Main.getInstance().getRandom().nextInt(player.getHand().size())));
            default -> {
                System.out.println("Veuillez rentrer une saisie valide.");
                activate(player);
            }
        }
    }
}

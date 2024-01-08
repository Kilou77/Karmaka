package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Game;
import com.lo02.Karmaka.objects.Player;

import java.util.Scanner;

public class Dwindle extends Card {

    public Dwindle() {
        super("Dernier Souffle", 1, Color.RED, "Le joueur de votre choix défausse une carte de sa Main.");
    }

    @Override
    public void activate(Player player) {
        System.out.println("Choisissez un joueur : 1 pour vous, 2 pour l'adversaire");
        String sc = Main.getScanner().nextLine();
        switch (sc) {
            case "1" -> Game.getRuins().addCard(player.playerPick());
            case "2" -> Game.getRuins().addCard(player.getOtherPlayer().playerPick());
            default -> {
                System.out.println("Veuillez rentrer une saisie valide.");
                activate(player);
            }
        }
    }
}

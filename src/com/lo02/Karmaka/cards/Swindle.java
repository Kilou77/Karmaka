package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Swindle extends Card {

    public Swindle() {
        super("Duperie", 3, Color.BLUE, "Regardez 3 cartes de la Main d’un rival. Ajoutez-en une à votre Main.");
    }

    @Override
    public void activate(Player player) {
        //TODO
        //action of the card
        player.getOtherPlayer().showRivalHand(3);
        String sc = Main.getInstance().getScanner().nextLine();
        switch (sc) {
            case "0" -> {
                Card c = player.getOtherPlayer().getHand().getFirst();
                System.out.println("Vous prenez : " + c.getName() + "dans la main de votre rival.");
                player.getOtherPlayer().getHand().remove(c);
                player.getHand().add(c);
                System.out.println("Et :" + c.getName() + "est maintenant la carte en dernière position de votre main.");
            }
            case "1" -> {
                Card c = player.getOtherPlayer().getHand().get(1);
                System.out.println("Vous prenez : " + c.getName() + "dans la main de votre rival.");
                player.getOtherPlayer().getHand().remove(c);
                player.getHand().add(c);
                System.out.println("Et :" + c.getName() + "est maintenant la carte en dernière position de votre main.");
            }
            case "2" -> {
                Card c = player.getOtherPlayer().getHand().get(2);
                System.out.println("Vous prenez : " + c.getName() + "dans la main de votre rival.");
                player.getOtherPlayer().getHand().remove(c);
                player.getHand().add(c);
                System.out.println("Et :" + c.getName() + "est maintenant la carte en dernière position de votre main.");
            }
        }
    }
}

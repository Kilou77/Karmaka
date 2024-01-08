package com.lo02.Karmaka.cards;
import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Denial extends Card {

    public Denial() {
        super("Déni", 2, Color.BLUE, "Défaussez une carte de votre Main. Copiez le pouvoir de cette carte.");
    }

    @Override
    public void activate(Player player) {
        //action of the card
        System.out.println("Choisissez une carte à défausser");
        Card c = null;
        c = player.playerPick();
        // copy of power of the card c
        System.out.println("Le pouvoir de la carte " + c.getName()  + " sera appliqué");
        player.getHand().remove(c);
        c.activate(player);


    }
}


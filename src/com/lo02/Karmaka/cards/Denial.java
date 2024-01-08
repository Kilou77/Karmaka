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
        player.showHand();
        player.getHand().get(Main.getInstance().getRandom().nextInt(player.getHand().size())).activate(player);
        System.out.println("Le pouvoir de cette carte sera appliqué");
    }
}


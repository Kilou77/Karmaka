package com.lo02.Karmaka.cards;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;

public class Thievery extends Card{

        public Thievery(){
            super("Vol",2, Color.BLUE,"Placez dans votre Main l’Oeuvre Exposée d'un rival.");
        }

        @Override
        public void activate(Player player) {
            player.getHand().add(player.getOtherPlayer().getDeeds().getCards().getFirst());
        }

}

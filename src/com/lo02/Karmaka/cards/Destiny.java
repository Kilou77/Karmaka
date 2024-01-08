package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Game;
import com.lo02.Karmaka.objects.Player;

public class Destiny extends Card {

    public Destiny() {
        super("Destinée", 2, Color.BLUE, "Regardez les 3 premières cartes de la Source ; ajoutez-en jusqu’à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.");
    }

    @Override
    public void activate(Player player) {
        Main.getInstance().getGame().showWell(3);
        System.out.println("Combien de cartes voulez vous mettre dans votre vie future ? (2 max)");
        Card c = null;
        int max = 2;
        String sc = null;
        sc = Main.getInstance().getScanner().nextLine();
        if (Integer.parseInt(sc) <= 2 && Integer.parseInt(sc) > 0) {
            for (int i = 1; i <= Integer.parseInt(sc); i++) {
                System.out.println("Choisissez l'index de la carte à ajouter à votre vie future");
                sc = Main.getInstance().getScanner().nextLine();
                player.getFutureLife().getCards().add(Main.getInstance().getGame().getWell().getCards().get(Integer.parseInt(sc)));
            }
        } else if (Integer.parseInt(sc) > 2) {
            System.out.println("Entrée invalide. Veuillez recommencer.");
            activate(player);
        }
        //remettre les cartes restantes dans l'ordre souhaité
    }
}

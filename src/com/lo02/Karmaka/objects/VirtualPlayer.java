package com.lo02.Karmaka.objects;


import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Card;
import com.lo02.Karmaka.enums.Strategy;
/**
 * Classe représentant un joueur virtuel dans le jeu Karmaka.
 * Un joueur virtuel est contrôlé par l'ordinateur et utilise une stratégie spécifiée.
 */
public class VirtualPlayer extends Player {
    /**
     * Stratégie utilisée par le joueur virtuel.
     */
    private final Strategy strategy;
    /**
     * Constructeur de la classe VirtualPlayer.
     *
     * @param strategy La stratégie utilisée par le joueur virtuel (OFFENSIVE, DEFENSIVE, RANDOM).
     */
    public VirtualPlayer(Strategy strategy) {
        this.strategy = strategy;
    }
    /**
     * Méthode appelée lors du tour de jeu du joueur virtuel.
     * Le joueur virtuel effectue des actions en fonction de la stratégie choisie.
     */
    @Override
    public void playTurn() {
        drawCard();
        switch (strategy) {
            case OFFENSIVE -> {

            }
            case DEFENSIVE -> {

            }
            case RANDOM -> {
                // Choix aléatoire d'une carte dans la main
                int card = Main.getInstance().getRandom().nextInt(this.getHand().size());
                Card cardToPlay = this.getHand().get(card);
                // Choix aléatoire d'une action parmi 4 : jouer pour les points, activer le pouvoir, garder pour la prochaine vie ou défausser la carte.
                int action = Main.getInstance().getRandom().nextInt(4);
                switch (action) {
                    case 0 -> {
                        cardToPlay.playForPoints(this);
                    }
                    case 1 -> {
                        this.getHand().remove(cardToPlay);
                        cardToPlay.activate(this);
                    }
                    case 2 -> {
                        cardToPlay.playFutureLife(this);
                    }
                    case 3 -> {
                        this.getHand().remove(cardToPlay);
                        Main.getInstance().getGame().getRuins().addCard(cardToPlay);
                        System.out.println("Vous avez défaussé la carte" + cardToPlay.getName());
                    }
                }
            }
        }
    }
    /**
     * Renvoie la stratégie utilisée par le joueur virtuel.
     *
     * @return La stratégie utilisée par le joueur virtuel.
     */
    public Strategy getStrategy() {
        return strategy;
    }
}

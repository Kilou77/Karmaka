package com.lo02.Karmaka.objects;


import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Card;
import com.lo02.Karmaka.enums.Strategy;

public class VirtualPlayer extends Player {

    private final Strategy strategy;

    public VirtualPlayer(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public void playTurn() {
        drawCard();
        switch (strategy) {
            case OFFENSIVE -> {

            }
            case DEFENSIVE -> {

            }
            case RANDOM -> {
                int card = Main.getInstance().getRandom().nextInt(this.getHand().size());
                Card cardToPlay = this.getHand().get(card);
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
}

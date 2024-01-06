package com.lo02.Karmaka.objects;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class CardManager {

    HashMap<Class<? extends Card>, Integer> cardList = new HashMap<>();
    //Création de la HashMap contenant l'ensemble des cartes du jeu

    public void init() {
        initCardList();
        generateWell();
    }

    public void initCardList() {
        cardList.put(AnotherDay.class,2);
        cardList.put(Denial.class,12);
        /*cardList.put(Dwindle.class, 3);
        cardList.put(Peek.class, 3);
        cardList.put(StolenDreams.class, 3);
        cardList.put(Thievery.class, 2);
         */
    }
    public void generateWell() {
        for (Class<? extends Card> c : cardList.keySet()) {
            for (int i = 0; i < cardList.get(c); i++) {
                try {
                    Main.getInstance().getGame().getWell().addCard(c.getDeclaredConstructor().newInstance());
                } catch (InstantiationException | NoSuchMethodException | IllegalAccessException |
                         InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}

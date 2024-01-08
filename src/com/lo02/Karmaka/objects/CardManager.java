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
        /*cardList.put(AnotherDay.class,3);*/
        cardList.put(Crisis.class,30);
        /*cardList.put(Denial.class,2);
        cardList.put(Destiny.class,2);
        cardList.put(Dwindle.class,2);
        cardList.put(Embody.class,2);
        cardList.put(HellsHeart.class,2);
        cardList.put(Jubilee.class,2);
        cardList.put(Longevity.class,2);
        cardList.put(Mimic.class,2);
        cardList.put(Panic.class,2);
        cardList.put(Peek.class,2);
        cardList.put(Recycle.class,2);
        cardList.put(Roulette.class,2);
        cardList.put(Salvage.class,2);
        cardList.put(Sowing.class,2);
        cardList.put(Spite.class,2);
        cardList.put(StolenDreams.class,2);
        cardList.put(Swindle.class,2);
        cardList.put(Thievery.class,2);
        cardList.put(Transmigrate.class,2);
        cardList.put(Vengeance.class,2);
        cardList.put(Voyage.class,2);
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

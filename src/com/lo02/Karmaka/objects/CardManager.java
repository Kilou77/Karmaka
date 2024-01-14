package com.lo02.Karmaka.objects;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
/**
 * La classe <code>CardManager</code> gère la liste des cartes disponibles dans le jeu Karmaka.
 * Elle initialise la liste des cartes et génère la pioche de cartes.
 */
public class CardManager {
    /**
     * HashMap contenant la liste des cartes disponibles et leur quantité respective.
     */
    HashMap<Class<? extends Card>, Integer> cardList = new HashMap<>();
    /**
     * Initialise la liste des cartes et génère la pioche de cartes.
     */
    public void init() {
        initCardList();
        generateWell();
    }
    /**
     * Initialise la liste des cartes avec leurs quantités respectives.
     * Les cartes sont représentées par leur classe et leur nombre associés.
     */
    public void initCardList() {
        cardList.put(AnotherDay.class,3);
        cardList.put(Crisis.class,3);
        cardList.put(Denial.class,3);
        cardList.put(Destiny.class,3);
        cardList.put(Dwindle.class,2);
        cardList.put(Embody.class,2);
        cardList.put(HellsHeart.class,2);
        cardList.put(Jubilee.class,2);
        cardList.put(Longevity.class,2);
        cardList.put(Mimic.class,2);
        cardList.put(Panic.class,2);
        cardList.put(Peek.class,3);
        cardList.put(Recycle.class,2);
        cardList.put(Roulette.class,2);
        cardList.put(Salvage.class,2);
        cardList.put(Sowing.class,2);
        cardList.put(Spite.class,2);
        cardList.put(StolenDreams.class,3);
        cardList.put(Swindle.class,2);
        cardList.put(Thievery.class,2);
        cardList.put(Transmigrate.class,3);
        cardList.put(Vengeance.class,2);
        cardList.put(Voyage.class,2);
    }
    /**
     * Génère la pioche de cartes en ajoutant les cartes à partir de la liste dans le jeu.
     * Utilise une boucle for pour générer les cartes.
     * En cas d'échec, lance une exception RuntimeException.
     */
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

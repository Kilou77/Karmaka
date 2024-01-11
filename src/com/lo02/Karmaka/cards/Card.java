package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.enums.Color;
import com.lo02.Karmaka.objects.Player;
/**
 * La classe abstraite <code>Card</code> représente une carte générique dans le jeu Karmaka.
 * Chaque carte possède un nom, une valeur en points, une couleur et une description.
 * Les cartes peuvent être activées par les joueurs, jouées pour leur pouvoir avec une méthode abstraite activate(), pour des points ou ajoutées à la Vie Future.
 */
public abstract class Card {
    /** Le nom de la carte. */
    private final String name;
    /** La valeur en points associée à la carte. */
    private final int points;
    /** La description de la carte. */
    private final String description;
    /** La couleur de la carte. */
    private final Color color;
    /**
     * Constructeur de la classe abstraite <code>Card</code>.
     * Initialise le nom, la valeur, la couleur grâce à une enum et la description de la carte.
     *
     * @param name Le nom de la carte.
     * @param value La valeur en points de la carte.
     * @param color La couleur de la carte.
     * @param description La description de la carte.
     */
    public Card(String name, int value, Color color, String description) {
        this.name = name;
        this.points = value;
        this.color = color;
        this.description = description;
    }
    /**
     * Méthode abstraite pour activer le pouvoir de la carte. Chaque carte doit définir son propre comportement lors de l'activation de la méthode de la classe enfant.
     *
     * @param player Le joueur qui active le pouvoir de la carte.
     */
    public abstract void activate(Player player);
    /**
     * Joue la carte pour ses points (valeur). Retire la carte de la main du joueur et l'ajoute à ses œuvres.
     *
     * @param player Le joueur qui joue la carte.
     */
    public void playForPoints(Player player) {
        player.getHand().remove(this);
        player.getDeeds().addCard(this);
        System.out.println("Vous avez disposé la carte: " + this.getName() + " dans vos oeuvres");
    }
    /**
     * Joue la carte pour la Vie Future. Retire la carte de la main du joueur et l'ajoute à sa Vie Future.
     *
     * @param player Le joueur qui joue la carte.
     */
    public void playFutureLife(Player player) {
        player.getHand().remove(this);
        player.getFutureLife().addCard(this);
        System.out.println("Vous avez ajouté la carte: " + this.getName() + " à votre vie future");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPoints() {
        return points;
    }

    public Color getColor() {
        return color;
    }
}

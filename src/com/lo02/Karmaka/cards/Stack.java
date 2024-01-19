package com.lo02.Karmaka.cards;

import com.lo02.Karmaka.Main;
import java.util.ArrayList;
import java.util.List;
/**
 * La classe <code>Stack</code> représente une pile de cartes dans le jeu Karmaka.
 * Les joueurs peuvent ajouter des cartes à la pile, en retirer un certain nombre, piocher des cartes,
 * choisir une carte dans la pile, afficher le contenu de la pile, etc.
 */
public class Stack {
    /** Liste des cartes dans la pile. */
    private final ArrayList<Card> cards;
    /** Nom de la pile. Ex : Pioche */
    private String name;
    /**
     * Constructeur de la classe <code>Stack</code>.
     * Initialise la pile avec un nom donné et une liste vide de cartes.
     *
     * @param name Le nom de la pile.
     */
    public Stack(String name) {
        this.cards = new ArrayList<>();
        this.name = name;
    }
    /**
     * Ajoute une carte à la pile.
     *
     * @param card La carte à ajouter à la pile.
     */
    public void addCard(Card card) {
        cards.add(card);
    }
    /**
     * Retire un certain nombre de cartes de la pile.
     *
     * @param number Le nombre de cartes à retirer.
     * @return Une liste de cartes retirées de la pile.
     */
    public List<Card> takeCards(int number) {
        List<Card> cardsPick = new ArrayList<>();
        for (int i = 0; i < number ; i++){
            Card card = cards.getFirst();
            cards.remove(card);
            cardsPick.add(card);
        }
        return cardsPick;
    }
    /**
     * Retire une carte de la pile.
     *
     * @return La carte retirée de la pile.
     */
    public Card takeCard() {
        Card card = cards.getFirst();
        cards.remove(card);
        return card;
    }
    /**
     * Pioche une carte dans une autre pile et l'ajoute à cette pile.
     *
     * @param stack La pile depuis laquelle la carte est piochée.
     */
    public void drawCard(Stack stack) {
        if (!cards.isEmpty()) {
            Card c = takeCard();
            stack.addCard(c);
            System.out.println("Vous avez pioché la carte : " + c.getName() + " dans votre pile. Elle sera placée en dernière position dans votre pile "+ stack.getName());
        } else {
                System.out.println("Votre pile est vide, par conséquent, vous n'avez pas pioché");
        }
    }
    /**
     * Permet au joueur de choisir une carte dans sa pile.
     *
     * @return La carte choisie par le joueur.
     */
    public Card pickCard() {
        Card c = null;
        boolean pass = false;
        while (c == null || pass) {
            showStack();
            String sc = null;

            try {
                System.out.println("Veuillez choisir le numéro associé à la carte présente dans votre pile " + this.getName() + " : ");
                sc = Main.getInstance().getScanner().nextLine();
                int cardNumber = Integer.parseInt(sc);

                // Verification of the card
                if (cardNumber >= 0 && cardNumber < cards.size()) {
                    c = cards.get(cardNumber);

                    //Description of the card
                    System.out.print("Voici la description de la carte : ");
                    System.out.println(c.getName() + " : " + c.getDescription());

                    System.out.println("Etes-vous sûr d'utiliser cette carte ? O/n ");
                    sc = Main.getInstance().getScanner().nextLine();

                    if (sc.equalsIgnoreCase("O")) {


                    } else if (sc.equalsIgnoreCase("n")) {
                        System.out.println("Veuillez choisir une autre carte");
                        c = null;
                    } else {
                        System.out.println("Mauvaise entrée, veuillez recommencer svp");
                        c = null;
                    }
                } else {
                    System.out.println("Numéro de carte invalide. Veuillez choisir un numéro valide.");
                    c = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro valide.");
                sc = null;
            }
        }

        return c;
    }
    /**
     * Affiche le contenu de la pile.
     */
    public void showStack() {
        // show what is in the active player's hand
        StringBuilder txt = new StringBuilder();
        if(!cards.isEmpty()){
            for (Card card : cards) {
                txt.append(" ").append(cards.indexOf(card)).append(") ").append(card.getName());
            }
            System.out.println("Votre pile " + this.getName() + " est composée de : " + txt);
        }else{
            System.out.println("Votre pile est vide");
        }

    }
    /**
     * Obtient la liste des cartes dans la pile.
     *
     * @return La liste des cartes dans la pile.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
    /**
     * Obtient le nom de la pile.
     *
     * @return Le nom de la pile.
     */
    public String getName() {
        return name;
    }
}

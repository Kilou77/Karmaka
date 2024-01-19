package com.lo02.Karmaka.objects;

import com.lo02.Karmaka.Main;
import com.lo02.Karmaka.cards.Card;
import com.lo02.Karmaka.cards.Stack;
import com.lo02.Karmaka.enums.KarmicScale;
import java.util.List;
import java.util.ArrayList;
/**
 * La classe <code>Player</code> représente un joueur dans le jeu Karmaka.
 * Chaque joueur possède une vie future, une œuvre exposée, une main, un deck et un anneau karmique.
 * Les joueurs peuvent piocher des cartes, jouer des cartes, choisir des actions, afficher leur main, etc.
 */
public class Player {

    /** Pile représentant la vie future du joueur. */
    private final Stack futureLife;
    /** Pile représentant les œuvres exposées par le joueur. */
    private final Stack deeds;
    /** Liste des cartes dans la main du joueur. */
    private final List<Card> hand;
    /** Pile représentant le deck du joueur. */
    private final Stack deck;
    /** Nom du joueur. */
    private String name;
    /** Niveau actuel de l'anneau karmique du joueur. */
    private int karmicRing;
    /** Échelle karmique du joueur. */
    private KarmicScale karmicScale;
    /**
     * Constructeur de la classe <code>Player</code>.
     * Initialise le joueur avec une vie future, des œuvres exposées, une main, un deck et une échelle karmique.
     */

    public Player() {
        askName();
        this.karmicScale = KarmicScale.DUNG_BEETLE;
        this.futureLife = new Stack("Vie Future");
        this.deeds = new Stack("Oeuvre(s) exposée(s)");
        this.hand = new ArrayList<>();
        this.karmicRing = 0;
        this.deck = new Stack("Deck");
    }
    /**
     * Demande au joueur d'entrer son nom, utilisé principalement lors de l'initialisation du joueur
     */
    public void askName() {
        String sc = null;
        while (sc == null) {
            System.out.println("Veuillez entrer le nom du joueur => ");
            sc = Main.getInstance().getScanner().nextLine();
        }
        this.name = sc;
        sc = null;
    }
    /**
     * Pioche une carte depuis le deck du joueur et l'ajoute à sa main.
     */
    public void drawCard() {
        if (!deck.getCards().isEmpty()) {
            Card c = deck.takeCard();
            hand.add(c);
            System.out.println("Vous avez pioché la carte : " + c.getName() + " dans votre pile. Elle sera placée en dernière position dans votre main.");
        } else {
            if (hand.isEmpty()) {
                reborn();
                return;
            } else {
                System.out.println("Votre pile est vide, par conséquent, vous n'avez pas pioché");
            }
        }
    }
    /**
     * Pioche une carte depuis la source du jeu et l'ajoute à la main du joueur.
     */
    public void drawWell() {
        Card c = Main.getInstance().getGame().getWell().takeCard();
        hand.add(c);
        System.out.println("Vous avez pioché la carte: " + c.getName() + " dans la source");
    }
    /**
     * Permet au joueur de jouer une carte de sa main en choisissant différentes actions.
     */
    public void playCard() {
        Card c = null;
        c = playerPick();
        boolean pass1 = false;
        String sc = null;
        while(!pass1){
            System.out.println("Veuillez choisir une action : ");
            System.out.println("1 : Jouer cette carte pour les points");
            System.out.println("2 : Jouer cette carte pour son pouvoir");
            System.out.println("3 : Garder cette carte pour sa prochaine vie");
            System.out.println("4 : Défausser cette carte");
            sc = Main.getInstance().getScanner().nextLine();
            int cardNumber = Integer.parseInt(sc);
            if (cardNumber >= 1 && cardNumber <= 4) {
                switch (sc) {
                    case "1" -> {
                        c.playForPoints(this);
                        pass1 = true;
                    }
                    case "2" -> {
                        getHand().remove(c);
                        c.activate(this);
                        pass1 = true;
                    }
                    case "3" -> {
                        c.playFutureLife(this);
                        pass1 = true;
                    }
                    case "4" -> {
                        hand.remove(c);
                        Main.getInstance().getGame().getRuins().addCard(c);
                        System.out.println("Vous avez défaussé la carte" + c.getName());
                        pass1 = true;
                    }
                    default -> {
                        System.out.println("Choix invalide. Veuillez choisir une action à réaliser");
                    }
                }
            } else {
                System.out.println("Choix invalide. La carte n'a pas été jouée. Veuillez choisir une action à réaliser");
                pass1 = false;
            }
        }


    }
    /**
     * Exécute le tour du joueur en lui permettant de piocher une carte et de jouer une carte.
     */
    public void playTurn() {
        System.out.println("C'est votre tour " + name + " !");
        drawCard(); //Fait piocher une carte à l'utilisateur depuis sa pile
        playCard(); //Fait jouer la carte de son choix à l'utilisateur
        //saveGame(); // proposer sauvegarde

    }
    /**
     * Sauvegarde le jeu.
     */
    public void saveGame(){
        int test = 0;
        while(test !=1){
            System.out.println("Voulez vous sauvegarder cette partie ?");
            String sc;
            sc = Main.getInstance().getScanner().nextLine();
            if (sc.equalsIgnoreCase("O")) {
                Main.getInstance().save();
                test = 1;
                System.out.println("La partie est sauvegardée");
            } else if (sc.equalsIgnoreCase("n")) {
                System.out.println("La partie n'est pas sauvegardée");
                test = 1;
            } else {
                System.out.println("Mauvaise entrée, veuillez recommencer svp");
                test = 0;
            }
        }

    }
    /**
     * Affiche la main du joueur.
     */
    public void showHand() {
        // show what is in the active player's hand
        StringBuilder txt = new StringBuilder();
        for (Card card : hand) {
            txt.append(" ").append(hand.indexOf(card)).append(") ").append(card.getName());
        }
        System.out.println("Votre main est composée de : " + txt);
    }
    /**
     * Affiche les cartes de la main adverse jusqu'à la position n.
     *
     * @param n Le nombre de cartes à afficher.
     */
    public void showRivalHand(int n) {
        StringBuilder txt = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            txt.append(" ").append(i).append(") ").append(this.getOtherPlayer().getHand().get(i).getName());
        }
        System.out.println("Les" + n + "premières cartes de la main adverse sont : " + txt);
    }
    /**
     * Permet au joueur de choisir une carte dans sa main.
     *
     * @return La carte choisie par le joueur.
     */
    public Card playerPick(){
        Card c = null;
        boolean pass = false;
        while (c == null || pass) {
            showHand();
            String sc = null;

            try {
                System.out.println("Veuillez choisir le numéro associé à la carte présente dans votre main : ");
                sc = Main.getInstance().getScanner().nextLine();
                int cardNumber = Integer.parseInt(sc);

                // Verification of the card
                if (cardNumber >= 0 && cardNumber < hand.size()) {
                    c = hand.get(cardNumber);

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
     * Permet au joueur de renaître, en fonction des points de ses œuvres exposées.
     * Les points sont répartis en fonction des couleurs des cartes (rouge, bleu, vert, mosaïque).
     * Si les points de l'œuvre exposée sont supérieurs au niveau karmique actuel, le joueur monte d'un niveau d'échelle karmique.
     * Sinon, l'anneau karmique du joueur augmente.
     */
    public void reborn() {
        int redPoints = 0;
        int bluePoints = 0;
        int greenPoints = 0;
        int mosaicPoints = 0;
        // Calcul des points en fonction des couleurs des cartes dans les œuvres exposées
        for (Card card : deeds.getCards()) {
            switch (card.getColor()) {
                case RED -> redPoints += card.getPoints();
                case BLUE -> bluePoints += card.getPoints();
                case GREEN -> greenPoints += card.getPoints();
                case MOSAIC -> {
                    redPoints += card.getPoints();
                    bluePoints += card.getPoints();
                    greenPoints += card.getPoints();
                }
            }
        }
        // Calcul du nombre maximum de points
        int maxPoints = Math.max(redPoints, Math.max(bluePoints, greenPoints));
        int karmicLevel = karmicScale.getValue();
        // Vérification si les points sont supérieurs au niveau karmique actuel
        if (maxPoints > karmicLevel) {
            this.karmicScale = KarmicScale.values()[karmicScale.ordinal() + 1];
        } else {
            this.karmicRing++;
        }
    }
    /**
     * Renvoie la liste des cartes dans la main du joueur.
     *
     * @return La liste des cartes dans la main du joueur.
     */
    public List<Card> getHand() {
        return hand;
    }
    /**
     * Renvoie le nom du joueur.
     *
     * @return Le nom du joueur.
     */
    public String getName() { return name; }
    /**
     * Renvoie la pile représentant le deck du joueur.
     *
     * @return La pile représentant le deck du joueur.
     */
    public Stack getDeck() {
        return deck;
    }
    /**
     * Renvoie la pile représentant les œuvres exposées par le joueur.
     *
     * @return La pile représentant les œuvres exposées par le joueur.
     */
    public Stack getDeeds() {
        return deeds;
    }
    /**
     * Renvoie la pile représentant la vie future du joueur.
     *
     * @return La pile représentant la vie future du joueur.
     */
    public Stack getFutureLife() {
        return futureLife;
    }
    /**
     * Renvoie le joueur adverse.
     *
     * @return Le joueur adverse.
     */
    public Player getOtherPlayer() {
        Game game = Main.getInstance().getGame();
        return (game.getPlayer1() == this) ? game.getPlayer2() : game.getPlayer1();
    }

}
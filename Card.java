// Lab 2
// Yosyp Vasyliev
// CS&145 

// For extra credit I:
// 1. Added enums instead of Strings to define the card faces and suits
// 2. Added a fuction that saves the card 

public class Card {
    private final CardFace face; // face of card
    private final CardSuit suit; // suit of card

    public Card(CardFace cardFace, CardSuit cardSuit) {
        this.face = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card
    } // end of Card


    @Override
    public String toString() {
            return face + " of " + suit;
    } // end of toString method 
} // end class Card
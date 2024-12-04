import java.security.SecureRandom; 

public class DeckOfCards {
    // generator of a random number 
    private static final SecureRandom randomNumbers = new SecureRandom(); 
    private static final int NUMBER_OF_CARDS = 52; // 52 is the total amount of cards
    private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
    private int currentCard = 0; 

    public DeckOfCards() {
        int count = 0;
        for (CardFace face : CardFace.values()) {
            for (CardSuit suit : CardSuit.values()) {
                deck[count++] = new Card(face, suit); // create card with face and suit
            } // end for loop
        } // end of for loop
    } // end of DeckOfCards
    
    public void shuffle() {
        currentCard = 0; 
        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS); // selects a random number 
            Card temp = deck[first]; // swap current Card with randomly selected Card 
            deck[first] = deck[second];
            deck[second] = temp;  
        } // end for loop
    } // end of shuffle
   
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (currentCard < deck.length) {
            return deck[currentCard++]; // return current Card in array
        } else {
            return null; // returning null to indicate that all Cards were dealt
        } // end if/else
    } // end of dealCard
} // end of DeckOfCards
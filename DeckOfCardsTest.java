import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DeckOfCardsTest {
    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // Shuffle the deck

        // Save the output to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("deck_output.txt"))) {
            StringBuilder lineBuilder = new StringBuilder(); // Use StringBuilder to create a line

            for (int i = 1; i <= 52; i++) {
                Card card = myDeckOfCards.dealCard();
                if (card != null) {
                    // Add the card to the line with a space
                    lineBuilder.append(card.toString()).append("     "); // Add spaces between cards
                    
                    // Print to console
                    System.out.printf("%-19s", card); // Adjust formatting for display
                    
                    // After every four cards, write the line to the file and reset
                    if (i % 4 == 0) {
                        writer.write(lineBuilder.toString().trim()); // Write the line to the file
                        writer.newLine(); // New line in the file
                        System.out.println(); // New line in the console
                        lineBuilder.setLength(0); // Reset the StringBuilder for the next line
                    }// end of if for the output
                }// end of if
            }// end of for loop

            // If there are remaining cards not in a complete group of four
            if (lineBuilder.length() > 0) {
                writer.write(lineBuilder.toString().trim()); // Write remaining cards to file
                writer.newLine(); // New line in the file
            }// end of if

        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }// end of exception
    }// end of main method
}// end of DeckOfCardsTest class
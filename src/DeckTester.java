/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] suits = {"Hearts", "Spades", "Clubs", "Diamonds"};
		String[] ranks = {"Jacks", "Kings", "Queens", "Ace"};
		int[] pointValues = {4, 5, 10, 11};
		Deck deck1 = new Deck(ranks, suits, pointValues);
		System.out.println(deck1.size());
		System.out.println(deck1.isEmpty());
		System.out.println(deck1.deal());
		System.out.println(deck1.deal());

				
		
//		Card card1 = new Card("Ace", "Clubs", 1);
//		Card card2 = new Card("5", "Spades", 1);
//		Card card3 = new Card("King", "Hearts", 1);
		
		
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}
}

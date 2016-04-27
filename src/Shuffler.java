
import java.util.Arrays;
import java.util.Random;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 10;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3, 4 ,5 ,6 ,7 ,8 ,9, 10};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(flip());
		int[] permutation1 = {1, 2, 4, 6, 3, 8, 7, 9 ,5, 10};
		int[] permutation2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(arePermutations(permutation1, permutation2));
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int[] shuffled = new int[values.length];
		int k = 0;
		for (int j = 0; j < (values.length+1)/2; j++) {
			shuffled[k] = values[j];
			k = k + 2;
		}
		k = 1;
		for (int j = (values.length+1)/2; j < values.length; j++) {
			shuffled[k] = values[j];
			k = k + 2;
		}
		for (int l = 0; l < values.length; l++) {
			values[l] = shuffled[l];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		Random rn = new Random();
		for(int k = values.length-1; k > 0; k--) {
			int r = rn.nextInt(k);
			int temp = values[k];
			values[k] = values[r];
			values[r] = temp;
		}
	}
	
	public static String flip() {
		Random rn = new Random();
		int r = rn.nextInt(3);
		if(r == 2 || r == 1) {
			return "heads";
		}
		else return "tails";
	}
	
	public static boolean arePermutations(int[] a1, int[] a2) {
		Arrays.sort(a1);
		Arrays.sort(a2);
		if(a1.length != a2.length){
			return false;
		}
		for(int i = 0; i <= a1.length - 1; i++) {
			if(a1[i] != a2[i]) return false; 
		}
		return true;
	}
}

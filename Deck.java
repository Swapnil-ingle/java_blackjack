import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	private static int min = 2;
	private static int max = 11;
	private static Random rand = new Random();

	// This will draw a random card with values from 2-11
	public static int drawCard() {
		return rand.nextInt((max - min) + 1) + min;
	}

	public static List<Integer> drawCards(int n) {
		List<Integer> cards = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			cards.add(rand.nextInt((max - min) + 1) + min);
		}

		return cards;
	}
}

import java.util.Random;

public class Deck {
	
	// This will draw a random card with values from 2-11
	public static int drawCard() {
		Random rand = new Random();
		int min = 2;
		int max = 11;
		int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}

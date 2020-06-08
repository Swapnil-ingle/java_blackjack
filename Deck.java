import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	private List<Card> cardSet = new ArrayList<Card>();
	private Random rand = new Random();
	
	public Deck() {
		CardSuitEnumes suits[] = CardSuitEnumes.values();
		for(CardSuitEnumes suit : suits) {
			for(int cardValue = 1 ; cardValue <= 14 ; cardValue++) {
				cardSet.add(new Card(cardValue, suit));
			}
		}
	}
	
	// This will draw a random card with values from 2-11
	public Card drawCard() {
		int randomIndex = rand.nextInt(cardSet.size()-1);
		Card card = cardSet.get(randomIndex);
		cardSet.remove(card);
		return card;
	}

	public List<Card> drawCards(int n) {
		List<Card> cards = new ArrayList<Card>();

		for (int i = 0; i < n; i++) {
			cards.add(drawCard());
		}

		return cards;
	}
}

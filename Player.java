
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

	private Scanner scanner = new Scanner(new InputStreamReader(System.in));
	private List<Integer> cards;

	private int total;

	private boolean isBust;

	public Player() {

		this.cards = new ArrayList<Integer>();
		this.total = 0;
		this.isBust = false;

	}

	// Validate to be "Hit" or "Stay"
	public String askNextMove() {

		// Filter
		if (this.isBust) {

			return "stay";

		}

		// string to be return with player's response
		String inputString = "";

		// Loop will iterate until player is not enter valid input
		while (true) {

			System.out.println("\nWould you like to \"hit\" or \"stay\"?");

			inputString = scanner.next();

			if (inputString.equalsIgnoreCase("stay") || inputString.equalsIgnoreCase("hit")) {
				break;
			}

			System.out.println("\nInvalid choice!!!");
		}

		return inputString;
	}

	// Should take card coming from Deck; update cards, total and isBust value
	public void handCards(List<Integer> newCards) {

		// Adding new cards coming from Deck to players cards
		this.cards.addAll(newCards);

		// variable to store new total
		int newTotal = 0;

		// Calculating the total of the cards
		for (int card : this.cards) {

			newTotal = newTotal + card;

		}

		// replacing old total with new one
		this.total = newTotal;

		// Setting the isBust value
		if (this.total > 21) {
			this.isBust = true;
		}
	}

	public List<Integer> getCards() {
		return cards;
	}

	public void setCards(List<Integer> cards) {
		this.cards = cards;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isBust() {
		return isBust;
	}

	public void setBust(boolean isBust) {
		this.isBust = isBust;
	}

}

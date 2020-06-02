
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	private Scanner scanner = new Scanner(new InputStreamReader(System.in));
	private List<Integer> cards = new ArrayList<Integer>();;
	private int total = 0;
	private boolean isBust = false;

	public String askNextMove() {
		// Filter
		if (this.isBust) {
			return "stay";
		}

		String inputString = "";

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

	public void handCards(List<Integer> newCards) {
		int newTotal = 0;

		for (int card : newCards) {
			newTotal = newTotal + card;
		}

		total = total + newTotal;
		cards.addAll(newCards);

		if (this.total > 21) {
			isBust = true;
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

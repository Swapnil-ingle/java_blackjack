import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	private Scanner scanner = new Scanner(new InputStreamReader(System.in));
	private List<Card> cards = new ArrayList<Card>();
	private int playerInitialAmount = 1000;
	private int bettingAmount = 0;
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

	public void handCards(List<Card> newCards) {
		int newTotal = 0;

		for (Card card : newCards) {
			newTotal = newTotal + card.getValue();
		}

		total = total + newTotal;
		cards.addAll(newCards);

		if (this.total > 21) {
			isBust = true;
		}
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
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

	public int getInitialAmount() {
		return playerInitialAmount;
	}

	public int getAddAmount() {
		return playerInitialAmount + bettingAmount;
	}

	public int getDeductAmount() {
		return playerInitialAmount - bettingAmount;
	}

	public void setBettingAmount(int bettingAmount) {
		this.bettingAmount = bettingAmount;
	}
	public int getBettingAmount() {
		return bettingAmount;
	}
}
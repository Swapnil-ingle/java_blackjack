import java.util.ArrayList;
import java.util.List;

public class BlackJackGame {

	private Player dealer;

	private Player human;

	private List<Integer> cards = new ArrayList<Integer>();

	public BlackJackGame() {

		this.dealer = new Dealer();

		this.human = new Human();

	}

	public void play() {

		this.initialDraw();

		// 1. Start with player's turn (Allow to "hit" multiple times). Check if busted
		// after each move.
		this.execPlayerTurn();

		// Checks if the player is busted
		if (this.human.isBust) {

			System.out.println("\nYour total is " + this.human.getTotal());
			System.out.println("Your total is busted");

			System.out.println("\nDEALER WON!");

			System.exit(0);
		}

		// 2. Then dealers turn (Should probably hit on sixteen or lower).
		this.execDealerTurn();

		// Checks if the dealer is busted
		if (this.dealer.isBust) {

			System.out.println("\nDealer's total is " + this.dealer.getTotal());
			System.out.println("Dealer's total is busted");

			System.out.println("\nYOU WON!");

			System.exit(0);

		}

		// 3. Given both dealer/player didn't go bust, round up and compare scores,

		// Showing totals
		System.out.println("\nYour total is " + this.human.getTotal());
		System.out.println("Dealer's total is " + this.dealer.getTotal());

		// Comparing totals
		if (this.human.getTotal() > this.dealer.getTotal()) {

			System.out.println("\nYOU WON!");

		} else if (this.human.getTotal() < this.dealer.getTotal()) {

			System.out.println("\nDEALER WON!");

		} else {

			// As per projects instructions if there is tie then dealer will win the round
			System.out.println("\nIt's tie.");
			System.out.println("DEALER WON!");

		}
	}

	private void initialDraw() {

		// Draw two card for the Player. Display
		initialDrawCards();

		// Updating cards, total, and isBust for human
		human.handCards(this.cards);

		// Showing cards and total of human
		System.out.println("\nYou got a " + this.cards.get(0) + " and a " + this.cards.get(1));
		System.out.println("Your total is " + human.getTotal());

		// Draw two card for the Dealer. Display one card.
		initialDrawCards();

		// Updating cards, total, and isBust for human
		dealer.handCards(this.cards);

		// Showing only one card of dealer.
		System.out.println("\nThe dealer has a " + this.cards.get(0) + " showing, and a hidden card.");
		System.out.println("His total is also hidden");

	}

	// Draws two cards and stores in List named cards
	private void initialDrawCards() {

		this.cards.clear();

		for (int i = 1; i <= 2; i++) {
			this.cards.add(Deck.drawCard());
		}
	}

	private void execDealerTurn() {
		// 1. Ask next move

		System.out.println("\nOkay. Dealer's turn.");
		System.out.println("His hidden card was " + this.dealer.getCards().get(1));
		System.out.println("His total was " + this.dealer.getTotal());

		// Iterate until dealer is not busted or he choses to stay
		while (!this.dealer.isBust) {
			if (this.dealer.askNextMove().equalsIgnoreCase("hit")) {

				// clears cards list
				this.cards.clear();

				System.out.println("\nDealer chose to hit.");

				// draws card
				int card = Deck.drawCard();

				System.out.println("He drew " + card);

				// adds to card to list
				this.cards.add(card);

				// send the card to add the current dealers card and update cards, total, and
				// isBust attribute
				this.dealer.handCards(cards);
				System.out.println("His total is " + this.dealer.getTotal());

			} else {

				// If dealers choses to stay then loop will be broke
				System.out.println("Dealer stays.");
				break;
			}
		}
	}

	private void execPlayerTurn() {

		// Iterate until dealer is not busted or he choses to stay
		while (!this.human.isBust) {
			if (this.human.askNextMove().equalsIgnoreCase("hit")) {

				// Clears cards list
				this.cards.clear();

				System.out.println("\nYou chose to hit.");

				// draws card
				int card = Deck.drawCard();
				System.out.println("You drew " + card);

				// adds to card to list
				this.cards.add(card);

				// send the card to add the current dealers card and update cards, total, and
				// isBust attribute
				this.human.handCards(cards);

				System.out.println("Your total is " + this.human.getTotal());

			} else {

				// If player choses to stay then loop will be broke
				System.out.println("You stays.");
				break;

			}
		}
	}
}

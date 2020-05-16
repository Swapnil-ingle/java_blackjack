# java_blackjack
Java project implementing the black-jack problem from 'programmingbydoing.com' (https://programmingbydoing.com/a/project-blackjack.html)

## PseudoCode

```
class MainClass {
	main () {
		BlackJackGame game = new BlackJackGame();
		game.play();
	}
}

class BlackJackGame {
	private Player dealer;

	private Player human;

	public BlackJack() {
		this.dealer = new Dealer();
		this.human = new Human();
	}

	public void play() {
		// initialDraw()

		// 1. Start with player's turn (Allow to "hit" multiple times). Check if busted after each move.

		// 2. Then dealers turn (Should probably hit on sixteen or lower).

		// 3. Given both dealer/player didn't go bust, round up and compare scores, display winner.
	}

	private void initialDraw() {
		// Draw two card for the Player. Display.
		// Draw two card for the Dealer. Display one card.
	}

	private void execDealerTurn() {
		// 1. Ask next move
		// 2. Draw card
		// 3. Hand card
	}

	private void execPlayerTurn() {
		// 1. Ask next move
		// 2. Draw card
		// 3. Hand card
	}
}

static class Deck {
	public int drawCard(); // This will draw a random card with values from 2-11
}

class Player {
	private int[] cards;

	private int total;

	private boolean isBust;

	private String askNextMove() {...}; // Validate to be "Hit" or "Stay"

	private void handCards(int[] cards) {...}; // Should take card coming from Deck; update cards, total and isBust value
}

class Dealer extends Player {
	private String askNextMove() {...}; // Validate to be "Hit" or "Stay"
}

class Human extends Player {
	private String askNextMove() {...}; // Should be "Hit" or "Stay"
}
```

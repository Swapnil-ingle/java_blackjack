import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackGame {

	private Player dealer;

	private Player human;

	private List<Integer> cards = new ArrayList<Integer>();

	Scanner scanner = new Scanner(System.in);

	public BlackJackGame() {

		this.dealer = new Dealer();

		this.human = new Human();

	}

	public void play() {
        
		System.out.println();
        System.out.println(BLACK_JACK_BANNER);
        System.out.println("Welcome To BLACKJACK Game!");
        System.out.println();

		// initialDraw()
		this.initialDraw();

		// 1. Start with player's turn (Allow to "hit" multiple times).Check if busted after each move.
		this.execPlayerTurn();

		if (this.human.isBust) {

			System.out.println("\nYour total is " + this.human.getTotal());
			System.out.println("Your total is busted");

			System.out.println("\nDEALER WON!");

			playAgain();
		}

		// 2. Then dealers turn (Should probably hit on sixteen or lower).
		this.execDealerTurn();

		if (this.dealer.isBust) {

			System.out.println("\nDealer's total is " + this.dealer.getTotal());
			System.out.println("Dealer's total is busted");

			System.out.println("\nYOU WON!");

			playAgain();

		}

		// 3. Given both dealer/player didn't go bust, round up and compare scores, display winner.
		System.out.println("\nYour total is " + this.human.getTotal());
		System.out.println("Dealer's total is " + this.dealer.getTotal());

		
		if (this.human.getTotal() > this.dealer.getTotal()) {

			System.out.println("\nYOU WON!!!");

		} else if (this.human.getTotal() < this.dealer.getTotal()) {

			System.out.println("\nDEALER WON!!!");

		} else {

			System.out.println("\nIt's tie.");
			System.out.println("DEALER WON!!!");

		}
		playAgain();
	}

	private void initialDraw() {

		initialDrawTwoCards();

		human.handCards(this.cards);

		System.out.println("\nYou got a " + this.cards.get(0) + " and a " + this.cards.get(1));
		System.out.println("Your total is " + human.getTotal());

		initialDrawTwoCards();

		dealer.handCards(this.cards);

		System.out.println("\nThe dealer has a " + this.cards.get(0) + " showing, and a hidden card.");
		System.out.println("His total is also hidden!!!");

	}

	private void initialDrawTwoCards() {

		this.cards.clear();

		for (int i = 1; i <= 2; i++) {
			this.cards.add(Deck.drawCard());
		}
	}

	private void execDealerTurn() {

		System.out.println("\nOkay. Dealer's turn.");
		System.out.println("His hidden card was " + this.dealer.getCards().get(1));
		System.out.println("His total was " + this.dealer.getTotal());

		while (!this.dealer.isBust) {
			if (this.dealer.askNextMove().equalsIgnoreCase("hit")) {

				this.cards.clear();

				System.out.println("\nDealer chose to hit.");

				int card = Deck.drawCard();

				System.out.println("He drew " + card);

				this.cards.add(card);

				this.dealer.handCards(cards);
				System.out.println("His total is " + this.dealer.getTotal());

			} else {

				System.out.println("Dealer stays!!!");
				break;
			}
		}
	}

	private void execPlayerTurn() {

		while (!this.human.isBust) {
			if (this.human.askNextMove().equalsIgnoreCase("hit")) {

				
				this.cards.clear();

				System.out.println("\nYou chose to hit.");

				int card = Deck.drawCard();
				System.out.println("You drew: " + card);

				this.cards.add(card);

				this.human.handCards(cards);

				System.out.println("Your total is: " + this.human.getTotal());

			} else {

				System.out.println("You stays!!!");
				break;

			}
		}
	}
	private void playAgain() {
		
		System.out.println("Do you want to play again? \"Yes\" & \"No\" :");
		while(true) {
			
			String gameStopOrNot = scanner.next();

			if(gameStopOrNot.equalsIgnoreCase("YES")) {
				
				BlackJackGame game = new BlackJackGame();
				game.play();

			} else if(gameStopOrNot.equalsIgnoreCase("NO")) {

				System.exit(0);

			} else {

				System.out.println("Please type \"Yes\" or \"No\":");
			}
		
		}
	} 
     public static final String BLACK_JACK_BANNER =
        "###########################################################################################################################\n" +
        "#                                                                                                                         #\n" +
        "#   #######      #             #########       ########   #     ###             #    ########       #######   #     ###   #\n" +
        "#   #      #     #            #         #     #           #    #                #   #        #     #          #    #      #\n" +
        "#   #        #   #            #         #    #            #   #                 #   #        #    #           #   #       #\n" +
        "#   #        #   #            #         #    #            #  #                  #   #        #   #            #  #        #\n" +
        "#   #        #   #            #         #    #            # #                   #   #        #   #            # #         #\n" +
        "#   #########    #            ###########    #            ##                    #   ##########   #            ##          #\n" +
        "#   #        #   #            #         #    #            # #       #           #   #        #   #            # #         #\n" +
        "#   #        #   #            #         #    #            #  #      #           #   #        #   #            #  #        #\n" +
        "#   #        #   #            #         #    #            #   #      #          #   #        #    #           #   #       #\n" +
        "#   #       #    #            #         #     #           #    #      #        #    #        #     #          #    #      #\n" +
        "#   #######      ##########   #         #      ########   #     ###    ########     #        #      #######   #     ###   #\n" +
        "#                                                                                                                         #\n" +
        "###########################################################################################################################\n";
}
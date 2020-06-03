<<<<<<< HEAD
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
=======
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

>>>>>>> DRIVER_BLACKJACK_IMPL

public class BlackJackGame {

	private Player dealer;

	private Player human;

<<<<<<< HEAD
	private List<Integer> cards = new ArrayList<Integer>();
=======
	private List<Integer> cards;

	private Deck deck = new Deck();
>>>>>>> DRIVER_BLACKJACK_IMPL

	Scanner scanner = new Scanner(System.in);

	public BlackJackGame() {
<<<<<<< HEAD

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

=======
		this.dealer = new Dealer();
		this.human = new Human();
	}

	public void play() {
		System.out.println();
        	System.out.println(BLACK_JACK_BANNER);
        	System.out.println("Welcome To BLACKJACK Game!");
        	System.out.println();

		this.initialDraw();
		
		this.execPlayerTurn();
		this.playerBusted();
		
		this.execDealerTurn();
		this.playerBusted();
		
		System.out.println("\nYour total is: " + this.human.getTotal());
		System.out.println("Dealer's total is: " + this.dealer.getTotal());
		
		if (this.human.getTotal() > this.dealer.getTotal()) {
			System.out.println("\nYOU WON!!!");
		} else if (this.human.getTotal() < this.dealer.getTotal()) {
			System.out.println("\nDEALER WON!!!");
		} else {
			System.out.println("\nIt's tie.");
			System.out.println("DEALER WON!!!");
>>>>>>> DRIVER_BLACKJACK_IMPL
		}
		playAgain();
	}

	private void initialDraw() {
<<<<<<< HEAD

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

=======
		cards = new ArrayList<Integer>();
		initialDrawTwoCards();
		human.handCards(this.cards);
		System.out.println("\nYou got a " + this.cards.get(0) + " and a " + this.cards.get(1));
		System.out.println("Your total is: " + human.getTotal());

		initialDrawTwoCards();
		dealer.handCards(this.cards);
		System.out.println("\nThe dealer has a " + this.cards.get(0) + " showing, and a hidden card.");
		System.out.println("His total is also hidden!!!");
	}

	private void initialDrawTwoCards() {
		this.cards.clear();
		for (int i = 1; i <= 2; i++) {
			this.cards.add(deck.drawCard());
		}
	}

	private void execPlayerTurn() {
		while (!this.human.isBust()) {
			if (this.human.askNextMove().equalsIgnoreCase("hit")) {
				this.cards.clear();
				System.out.println("\nYou chose to hit.");
				int card = deck.drawCard();
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

	private void execDealerTurn() {
		System.out.println("\nOkay. Dealer's turn.");
		int hiddenCard = this.dealer.getCards().get(1); 
		System.out.println("His hidden card was: " + hiddenCard);
		System.out.println("His total was: " + this.dealer.getTotal());
		while (!this.dealer.isBust()) {
			if (this.dealer.askNextMove().equalsIgnoreCase("hit")) {
				this.cards.clear();
				System.out.println("\nDealer chose to hit.");
				int card = deck.drawCard();
				System.out.println("He drew: " + card);
				this.cards.add(card);
				this.dealer.handCards(cards);
				System.out.println("His total is: " + this.dealer.getTotal());
			} else {
>>>>>>> DRIVER_BLACKJACK_IMPL
				System.out.println("Dealer stays!!!");
				break;
			}
		}
	}

<<<<<<< HEAD
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
=======
	private void playerBusted() {
		if (human.isBust()) {
			System.out.println("\nYour total is: " + this.human.getTotal());
			System.out.println("Your total is Busted!!!");
			System.out.println("\nDealer WON!!!");
			playAgain();
		} else if (dealer.isBust()) {
			System.out.println("\nDealer's total is: " + this.human.getTotal());
			System.out.println("Dealer's total is Busted!!!");
			System.out.println("\nYou WON!!!");
			playAgain();
>>>>>>> DRIVER_BLACKJACK_IMPL
		}
	}
	
	private void playAgain() {
<<<<<<< HEAD
		
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
		
=======
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
>>>>>>> DRIVER_BLACKJACK_IMPL
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
||||||| merged common ancestors
=======
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BlackJackGame {
	private Scanner scanner = new Scanner(System.in);

	private Player dealer = new Dealer();

	private Player human = new Human();

	public void play() {
		System.out.println("\n" + BLACK_JACK_BANNER);
		System.out.println("Welcome To BLACKJACK Game!\n");

		initialDraw();

		execPlayerTurn(human);
		concludeIfBusted(human);

		System.out.println("\nOkay Dealer's Turn!!! ");

		int hiddenCard = dealer.getCards().get(1);
		System.out.println("\nHis hidden card was : " + hiddenCard);
		System.out.println("His Total is : " + dealer.getTotal());

		execPlayerTurn(dealer);
		concludeIfBusted(dealer);

		System.out.println("\nYour total is: " + human.getTotal());
		System.out.println("Dealer's total is: " + dealer.getTotal());
		
		if (human.getTotal() > dealer.getTotal()) {
			System.out.println("\n***************YOU WON!!!!!***************");
		} else if (human.getTotal() < dealer.getTotal()) {
			System.out.println("\n***************DEALER WON!!!!!***************");
		} else {
			System.out.println("\nIt's tie.");
			System.out.println("***************DEALER WON!!!!!***************");
		}

		playAgain();
	}

	private void initialDraw() {
		List<Integer> humanCards = Deck.drawCards(2);

		human.handCards(humanCards);
		System.out.println("\nYou got a " + humanCards.get(0) + " and a " + humanCards.get(1));
		System.out.println("Your total is : " + human.getTotal());

		List<Integer> dealerCards = Deck.drawCards(2);

		dealer.handCards(dealerCards);
		System.out.println("\nThe dealer has a " + dealerCards.get(0) + " showing, and a hidden card.");
		System.out.println("His total is also hidden!!!");
	}

	private void execPlayerTurn(Player player) {
		String playerName = resolvePlayerName(player);

		while (!player.isBust()) {
			if (player.askNextMove().equalsIgnoreCase("hit")) {
				System.out.println("\n" + playerName + " choose to HIT!");

				int card = Deck.drawCard();
				System.out.println("\n" + playerName + " Drew: " + card);

				player.handCards(Collections.singletonList(card));
				System.out.println(playerName + " total is : " + player.getTotal());
			} else {
				System.out.println("\n" + playerName + " Stays!!!");
				break;
			}
		}
	}

	private void concludeIfBusted(Player player) {
		String playerName = resolvePlayerName(player);

		if (player.isBust()) {
			System.out.println("\n"+ playerName +" total is: " + player.getTotal());
			System.out.println(playerName + " total is busted!!!!!!");
			String winner = playerName.equalsIgnoreCase("You") ? "Dealer" : "You";

			System.out.println("\n***************"  + winner + " WON!!!!***************");
			playAgain();
		}
	}

	private String resolvePlayerName(Player player) {
		return player instanceof Human ? "Player" : "Dealer";
	}

	private void playAgain() {
		System.out.println("\nDo you want to play again? (Yes/No)");

		while(true) {
			String gameStopOrNot = scanner.next();
			if (gameStopOrNot.equalsIgnoreCase("YES")) {
				BlackJackGame game = new BlackJackGame();
				game.play();
			} else if (gameStopOrNot.equalsIgnoreCase("NO")) {
				System.exit(0);
			} else {
				System.out.println("Please enter \"Yes\" or \"No\"");
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
>>>>>>> DRIVER_BLACKJACK_IMPL

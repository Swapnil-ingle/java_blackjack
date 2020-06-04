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
		return player instanceof Human ? "You" : "Dealer";
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
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class BlackJackGame {
	
	Scanner scanner = new Scanner(System.in);
	
	private List<Integer> cards = new ArrayList<Integer>();
	
	private Player dealer;

	private Player human;

	public void BlackJack() {
		
        	this.dealer = new Dealer();
		
        	this.human = new Human();
	}

    public void play() {
        
        System.out.println(BLACK_JACK_BANNER);
        System.out.println("Welcome To BLACKJACK Game!");
	System.out.println();
		
	// initialDraw()
	this.initialDraw();
        
	//1. Start with player's turn (Allow to "hit" multiple times). Check if busted after each move.
        this.execDealerTurn();
        if (this.dealer.isBust) {

            System.out.println("Dealer's Total is: " + this.dealer.getTotal());
            System.out.println("Dealer's Total is Busted !!!");
            System.out.println("You Won!!!");
            playAgain();
        }
        
	// 2. Then dealers turn (Should probably hit on sixteen or lower).
        this.execPlayerTurn();
        if (this.human.isBust) {
            System.out.println("Your total is: "+ this.human.getTotal());
            System.out.println("Your Total is Busted !!!");
            System.out.println("Dealer Won !!!");
            playAgain();
        }
        
	// 3. Given both dealer/player didn't go bust, round up and compare scores, display winner.
	if (this.human.getTotal() < this.dealer.getTotal()) {
            System.out.println("Dealer Won !!!");
            playAgain();
        } else if (this.human.getTotal() > this.dealer.getTotal()) {
            System.out.println("You Won !!!");
            playAgain();
        } else {
            System.out.println("Game was Tied!!!!");
            playAgain();
        }
		
	}

	private void initialDraw() {
		
        	// for Human
        	initialDrawTwoCards();
		human.handCards(this.cards);
        	System.out.println("You got " + this.cards.get(0) + " and " + this.cards.get(1));
		System.out.println("Your Total is"+ human.getTotal());

        	//for Dealer
        	initialDrawTwoCards();
        	dealer.handCards(this.cards);
        	System.out.println("Dealer got"+ this.cards.get(0) + "And a hidden card");
        	System.out.println("His Total is Hidden Too!!!");
	}

	private void initialDrawTwoCards() {
        
        	this.cards.clear();
		
        	for (int i = 0; i < 2; i++) {
			this.cards.add(Deck.drawCard());
		}
	}
	
	private void execDealerTurn() {
		
	        System.out.println("Now, Dealer's Turn !!!!!");
	        System.out.println("His Hidden card is: " + this.dealer.getCards().get(1));
	        System.out.println("His Total is :" + this.dealer.getTotal());
	
	        while (!this.dealer.isBust) {
	
	            if(this.dealer.askNextMove().equalsIgnoreCase("hit")) {
	
	                this.cards.clear();

	                System.out.println("Dealer Choosed to Hit");
	                int card = Deck.drawCard();

	                this.cards.add(card);
	                this.dealer.handCards(cards);
	                System.out.println("His Total is:"+ this.dealer.getTotal());
	            
		  } else {

	                System.out.println("Dealer Stays!!!!!!!");
	                break;

            	  }
        	} 

	}

	private void execPlayerTurn() {
		
        	while (!this.human.isBust) {

	            if (this.human.askNextMove().equalsIgnoreCase("hit")) {

	                this.cards.clear();

	                System.out.println("You Choose to Hit!!");
	                int card = Deck.drawCard();
	                System.out.println("You got"+ card);

	                this.cards.add(card);
      		        this.human.handCards(cards);
                	System.out.println("Your Total is"+ this.human.getTotal());
	
            	   } else {
         	       System.out.println("You Stays!!");
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

   

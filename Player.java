
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	
	private Scanner scanner = new Scanner(new InputStreamReader(System.in));
	protected List<Integer> cards;

	protected int total;

	protected boolean isBust;
	
	
	public Player() {
		this.cards = new ArrayList<Integer>();
		this.total = 0;
		this.isBust = false;
	}
	
	// Validate to be "Hit" or "Stay"
	 public String askNextMove() {
		 
		 // Filter
		 if(this.isBust) {
			 return "stay";
		 }
		 
		 String inputString = "";
		 while(true) {
			 System.out.println("\nWould you like to \"hit\" or \"stay\"?");
			 inputString = scanner.next();
			 
			 if( inputString.equalsIgnoreCase("stay") || inputString.equalsIgnoreCase("hit")) {
				 break;
			 }
			 
			 System.out.println("\nInvalid choice!!!");
		 }
		 return inputString;
	 }
	
	// Should take card coming from Deck; update cards, total and isBust value
	public void handCards(ArrayList<Integer> cards) {
		
		// Adding new cards coming from Deck to players cards
		this.cards.addAll(cards);
		
		// Calculating the total of the cards
		for(int card : this.cards) {
			this.total = this.total + card;
		}
		
		// Setting the isBust value
		if(this.total > 21) {
			
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

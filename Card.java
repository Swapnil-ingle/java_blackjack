
public class Card {
	private int cardValue = 0;
	private CardSuitEnumes suit;
	
	public Card(int cardValue, CardSuitEnumes suit) {
		this.cardValue = cardValue;
		this.suit = suit;
	}

	public int getCardValue() {
		return cardValue;
	}

	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}

	public CardSuitEnumes getSuit() {
		return suit;
	}

	public void setSuit(CardSuitEnumes suit) {
		this.suit = suit;
	}
	
	void show() {
		System.out.print(this);
	}
	
	public int getValue() {
		if(cardValue<10) {
			return cardValue;
		} else {
			return 10;
		}
	}
	
	public boolean equals(Object obj) {
		Card card = (Card)obj;
		
		if(card != null && card.cardValue == this.cardValue && card.suit == this.suit) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		String st = "DC"+ getSuitHexChar() + Integer.toHexString(this.cardValue);
		int cp=Integer.parseInt(st,16);
		char chArr[]=Character.toChars(cp);
		return "\uD83C"+String.valueOf(chArr);
	}
	
	private String getSuitHexChar() {
		switch (this.suit) {
		case SPADE:
			return "A";
		case HEART:
			return "B";
		case DIAMOND:
			return "C";
		case CLUB:
			return "D";
		default:
			return "0";
		}
	}
}

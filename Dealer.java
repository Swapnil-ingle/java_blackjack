public class Dealer extends Player {
	
	public Dealer() {
		
	}
	// Dealer should probably hit on sixteen or lower.
	public String askNextMove() {
		if (super.getTotal() <= 16) {
			return "hit";
		} else {
			return "stay";
		}
	}
}

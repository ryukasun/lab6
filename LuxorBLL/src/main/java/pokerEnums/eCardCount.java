package pokerEnums;

public enum eCardCount {
	One(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10);
	
	private eCardCount(final int CardCount){
		this.CardCount = CardCount;
	}

	private int CardCount;
	
	public int getCardCount(){
		return CardCount;
	}
}

package pokerBase;

import java.io.Serializable;

import pokerEnums.eCardCount;
import pokerEnums.eCardDestination;
import pokerEnums.eCardNo;
import pokerEnums.eCardVisibility;

public class CardDraw implements Serializable {

	private eCardCount CardPosition;
	private eCardDestination CardDestination;
	private eCardVisibility CardVisibility;
	private eCardCount CardCountDrawn;

	public CardDraw(eCardCount eCardPosition, eCardCount eCardCountDrawn, eCardDestination cardDestination,	eCardVisibility cardVisiblity) {
		super();
		this.CardCountDrawn = eCardCountDrawn;
		this.CardDestination = cardDestination;
		this.CardVisibility = CardVisibility;
		this.CardPosition = eCardPosition;
	}

	public eCardDestination getCardDestination() {
		return CardDestination;
	}

	public eCardVisibility getCardVisibility() {
		return CardVisibility;
	}

	public eCardCount getCardPosition() {
		return CardPosition;
	}

	public eCardCount getCardCountDrawn() {
		return CardCountDrawn;
	}


}

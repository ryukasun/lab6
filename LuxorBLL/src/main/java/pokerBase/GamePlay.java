package pokerBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

import pokerEnums.eDrawCount;

public class GamePlay implements Serializable   {

	private UUID GameID;
	private Rule rle;	
	private Deck GameDeck = null;

	private HashMap<UUID, Player> hmGamePlayers = new HashMap<UUID, Player>();
	private HashMap<UUID, Hand> hmGamePlayerHand = new HashMap<UUID, Hand>();
	private Hand CommonHand = new Hand();
	private Player GameDealer = null;
	private Player PlayerNextToAct = null;	
	private int[] iActOrder = null;

	private eDrawCount DrawCnt;
	
	
	public GamePlay(Rule rle, Player GameDealer)
	{
		this.setGameID(UUID.randomUUID());
		this.setGameDealer(GameDealer);
		this.rle = rle;
	}

	public UUID getGameID() {
		return GameID;
	}

	public void setGameID(UUID gameID) {
		GameID = gameID;
	}

	public Rule getRule()
	{
		return this.rle;
	}
	
	public HashMap<UUID, Player> getGamePlayers() {
		return hmGamePlayers;
	}

	public void setGamePlayers(HashMap<UUID, Player> gamePlayers) {
		this.hmGamePlayers = new HashMap<UUID, Player>(gamePlayers);
		
		Iterator it = getGamePlayers().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Player p = (Player)pair.getValue();
			this.addPlayerHand(p.getPlayerID());
		}
		
	}
	
	public Player getGamePlayer(UUID PlayerID)
	{
		return (Player) this.hmGamePlayers.get(PlayerID);
	}

	public Deck getGameDeck() {
		return GameDeck;
	}

	public void setGameDeck(Deck gameDeck) {
		GameDeck = gameDeck;
	}
	
	public Player getGameDealer() {
		return GameDealer;
	}

	private void setGameDealer(Player gameDealer) {
		GameDealer = gameDealer;
	}



	public int[] getiActOrder() {
		return iActOrder;
	}

	public void setiActOrder(int[] iActOrder) {
		this.iActOrder = iActOrder;
	}

	public eDrawCount getDrawCnt() {
		return DrawCnt;
	}

	public void setDrawCnt(eDrawCount nextDraw) {
		DrawCnt = nextDraw;
	}

	public Player ComputePlayerNextToAct(int iCurrentPosition)
	{
		int [] iNextOrder = GetOrder(iCurrentPosition);
		
		for (int i : iNextOrder)
		{
			if (getPlayerByPosition(i) != null)
			{
				if (i == iCurrentPosition)
					return null;
				else
					return getPlayerByPosition(i);	
			}				
		}
		
		return null;
				
		/*
		int iNextPosition = -1;
		try {
			for (int i : iOrder) {
				if (iCurrentPosition == i) {
					iNextPosition = iOrder[i + 1];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// Whoops! Asking for something beyond the size of the array
			iNextPosition = iOrder[0];
		}
		
		if (getPlayerByPosition(iNextPosition) == null)
		{
			return ComputePlayerNextToAct(iNextPosition, iOrder);
		}
		else
		{
			return  getPlayerByPosition(iNextPosition);
		}
		*/					
	}
	public Player getPlayerNextToAct() {
		return PlayerNextToAct;
	}

	public void setPlayerNextToAct(Player playerNextToAct) {
		PlayerNextToAct = playerNextToAct;
	}
	

	public static int[] GetOrder(int iStartPosition) {
		int[] iPos = null;
		switch (iStartPosition) {
		case 1:
			int[] iPositions1 = new int[] { 2, 3, 4, 1 };
			iPos = iPositions1;
			break;
		case 2:
			int[] iPositions2 = new int[] { 3, 4, 1, 2 };
			iPos = iPositions2;
			break;
		case 3:
			int[] iPositions3 = new int[] { 4, 1, 2, 3 };
			iPos = iPositions3;
			break;
		case 4:
			int[] iPositions4 = new int[] { 1, 2, 3, 4 };
			iPos = iPositions4;
			break;
		}
		return iPos;
	}
	
	
	
	
	
	
	

	public static int NextPosition(int iCurrentPosition, int[] iOrder) {
		int iNextPosition = -1;
		try {
			for (int i : iOrder) {
				if (iCurrentPosition == i) {
					iNextPosition = iOrder[i + 1];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// Whoops! Asking for something beyond the size of the array
			iNextPosition = iOrder[0];
		}

		return iNextPosition;
	}
	
	public Player getPlayerByPosition(int iPlayerPosition)
	{
		Player pl = null;
		
		Iterator it = getGamePlayers().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			Player p = (Player)pair.getValue();
			if (p.getiPlayerPosition() == iPlayerPosition)
				pl = p;
		}
		
		return pl;
	}
	
	private void addPlayerHand(UUID PlayerID)
	{
		hmGamePlayerHand.put(PlayerID,  new Hand());
	}
	
	public Hand getPlayerHand(UUID PlayerID)
	{
		return (Hand)hmGamePlayerHand.get(PlayerID);
	}
	
	public Hand getCommonHand()
	{
		return CommonHand;
	}
	

	
}

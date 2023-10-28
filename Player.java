package mancala;

public class Player {
	private String playerName;
	private int playerNum;
	private int score;
	private Pocket[] pockets;
	static int spaces = 8;

	public Player(String playerName, int playerNum) {
		this.playerName = playerName;
		this.playerNum = playerNum;
		score = 0;
		pockets = new Pocket[spaces];
		for (int i = 0; i < pockets.length; i++) {
			pockets[i] = new Pocket(4, i);
		}
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Pocket[] getPockets() {
		return pockets;
	}

	public Pocket getPocketAt(int index) {
		return pockets[index];
	}

	public void setPockets(Pocket[] pockets) {
		this.pockets = pockets;
	}

	public void setPocketAt(int index, Pocket pocket) {
		pockets[index] = pocket;
	}

	public boolean isOnOwnEmpty(Pocket emptyPocket) {
		for (Pocket p : pockets)
			if (p == emptyPocket)
				return true;
		return false;
	}

	public boolean isWholeSideEmpty() {
		for (Pocket p : pockets)
			if (p.getStones() != 0)
				return false;
		return true;
	}
}

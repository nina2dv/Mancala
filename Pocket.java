package mancala;

public class Pocket {
	private int stones;
	private int position;

	public Pocket() {
		stones = 0;
		position = 0;
	}

	public Pocket(int stones, int position) {
		this.stones = stones;
		this.position = position;
	}

	public int getStones() {
		return stones;
	}

	public int getPosition() {
		return position;
	}

	public void setStones(int stones) {
		this.stones = stones;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isPocketEmpty() {
		if (stones == 0)
			return true;
		else
			return false;
	}

	public int getPocketLocation(Pocket[] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			if (gameBoard[i] == this)
				return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		return String.format("Position: %d, Stones: %d", position, stones);
	}
}

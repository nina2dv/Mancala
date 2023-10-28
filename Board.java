package mancala;

import java.util.Arrays;

public class Board {
	private Pocket[] gameBoard;
	private Player player1;
	private Player player2;

	public Board(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
		gameBoard = new Pocket[Player.spaces * 2];
		for (int i = 0; i < Player.spaces; i++) {
			gameBoard[i] = p1.getPocketAt(Player.spaces - 1 - i);
		}

		for (int i = 0; i < Player.spaces; i++) {
			gameBoard[Player.spaces + i] = p2.getPocketAt(Player.spaces - 1 - i);
		}
	}

	public int playerMove(Player player, Player opponent, int pickIndex) {
		Pocket pickPocket = player.getPocketAt(pickIndex);
		int numOfMoves = pickPocket.getStones();
		int position = pickPocket.getPosition();

		if (numOfMoves == 0)
			return -1;

		int location = pickPocket.getPocketLocation(gameBoard);
		int j = location + 1;
		pickPocket.setStones(0);
		if (numOfMoves > position + Player.spaces) {
			player.setScore(player.getScore() + 1);
			System.out.println(String.format("Player %d got 1 point", player.getPlayerNum()));
			numOfMoves -= 1;
		}
		boolean isLandedPocketEmpty = false;

		for (int z = 0; z < numOfMoves; z++, j++) {
			if (j >= gameBoard.length) {
				j = 0; // reset back to the beginning
			}
			isLandedPocketEmpty = gameBoard[j].isPocketEmpty();
			gameBoard[j].setStones(gameBoard[j].getStones() + 1);
		}

		Pocket pocketLanded = gameBoard[j - 1];
		// System.out.println(pocketLanded.getPosition());
		// System.out.println(pocketLanded.isPocketEmpty());
		// System.out.println(player.isOnOwnEmpty(pocketLanded));
		if (isLandedPocketEmpty && player.isOnOwnEmpty(pocketLanded)) {
			int opponentPocketPosition = Math.abs(Player.spaces - 1 - pocketLanded.getPosition());
			Pocket otherside = opponent.getPocketAt(opponentPocketPosition);
			int gained = otherside.getStones();
			player.setScore(player.getScore() + gained);
			otherside.setStones(0);
			System.out.println(String.format("Player %d stole %d stones from pocket %d", player.getPlayerNum(), gained,
					opponentPocketPosition));
		}
		return 0;
	}

	@Override
	public String toString() {
		String result = String.format("%s>->->->\n", "\t".repeat(Player.spaces / 2 + 1));
		result += "p1 side: \t";
//		for (int i = 0; i < Player.spaces; i++) {
//			result += "\t" + gameBoard[i].getPosition() + ":" + gameBoard[i].getStones();
//		}
		for (int i = 0; i < Player.spaces; i++) {
			result += gameBoard[i].getStones() + "\t";
		}
		result += "\n         \t";
		for (int i = 0; i < Player.spaces; i++) {
			result += String.format("-%d-\t", gameBoard[i].getPosition());
		}
		result += String.format("\nP1 Score: %d%sP2 Score: %d\n", player1.getScore(), "\t".repeat(Player.spaces + 1),
				player2.getScore());
		result += "p2 side: \t";
//		for (int i = 0; i < Player.spaces; i++) {
//			result += "\t" + gameBoard[gameBoard.length - 1 - i].getPosition() + ":"
//					+ gameBoard[gameBoard.length - 1 - i].getStones();
//		}
		for (int i = 0; i < Player.spaces; i++) {
			result += gameBoard[gameBoard.length - 1 - i].getStones() + "\t";
		}
		result += "\n         \t";
		for (int i = 0; i < Player.spaces; i++) {
			result += String.format("-%d-\t", gameBoard[gameBoard.length - 1 - i].getPosition());
		}
		result += String.format("\n%s<-<-<-<\n", "\t".repeat(Player.spaces / 2 + 1));

		return result;
	}

	public String altString() {
		return Arrays.toString(gameBoard);
	}

}

package mancala;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOfPockets = -1;
		
		System.out.print("Enter Player 1's name: ");
		String p1Name = input.nextLine();
		
		System.out.print("Enter Player 2's name: ");
		String p2Name = input.nextLine();
		
		do {
			System.out.print("Select a positive number of pockets (2 - n) ... Normal game is 6: ");
			numOfPockets = input.nextInt();
			
		} while (numOfPockets <= 1);
		
		Player.spaces = numOfPockets;
		
		Player p1 = new Player(p1Name, 1);
		Player p2 = new Player(p2Name, 2);

		Board board = new Board(p1, p2);

		System.out.println(board.toString());

		Player current = p1;

		while (!(p1.isWholeSideEmpty() || p2.isWholeSideEmpty())) {
			int b = -1;
			do {
				System.out.print(String.format("Player %d's turn... Pick your non-empty pocket (0 - %d): ",
						current.getPlayerNum(), Player.spaces - 1));
				int index = input.nextInt();
				if (index > Player.spaces - 1 || index < 0) {
					System.out.println("Invalid pocket index!");
					continue;
				}
				if (current == p1) {

					b = board.playerMove(p1, p2, index);
				} else {
					b = board.playerMove(p2, p1, index);
				}
			} while (b != 0);

			System.out.println(board.toString());
			// System.out.println(board.altString());

			if (current == p1)
				current = p2;
			else
				current = p1;
		}
		input.close();
		System.out.println("--- GAME END ---");

		if (p1.getScore() > p2.getScore()) {
			System.out.println(String.format("Player %d (%s) Wins!", p1.getPlayerNum(), p1.getPlayerName()));
		} else if (p2.getScore() > p1.getScore()) {
			System.out.println(String.format("Player %d (%s) Wins!", p2.getPlayerNum(), p2.getPlayerName()));
		} else {
			System.out.println("TIE!");
		}

	}
}

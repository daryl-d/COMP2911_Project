/**
 * @author Jaiden Ashmore
 * This stores the board state for the program
 */
public class Board {

	
	public Board (int width, int height) {
		tokens = new int[width][height];
		tokenWidth = width;
		tokenHeight = height;
		playerOne = null;
		playerTwo = null;
	}
	
	public void addHuman(String playerName) {
		if (playerOne == null) {
			playerOne = new Human(playerName);
		} else {
			playerTwo = new Human(playerName);
		}
	}
	
	public void addAI(String AIname) {
		if (playerOne == null) {
			playerOne = new AI(AIname);
		} else {
			playerTwo = new AI(AIname);
		}
	}
	
	public boolean gameFinished() {
		for (int x = 0; x < tokenWidth; x++) {
			for (int y = 0; y < tokenHeight; y++) {
				if (tokens[x][y] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void startGame() {
		playerTurn = playerOne;
	}
	
	public boolean validMove(int column) {
		if (column > 0 && column < tokenWidth) {
			if (tokens[column][tokenHeight-1] == 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean makeMove(int column) {
		if (validMove(column)) {
			for (int row = 0; row < tokenHeight; row++) {
				if (tokens[column][row] == 0) {
					if (playerTurn.equals(playerOne)) {
						tokens[column][row] = 1;
						playerTurn = playerTwo;
					} else {
						tokens[column][row] = 2;
						playerTurn = playerOne;
					}
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	private int[][] tokens;
	private int tokenWidth;
	private int tokenHeight;
	private Player playerTurn;
	private Player playerOne;
	private Player playerTwo;
}

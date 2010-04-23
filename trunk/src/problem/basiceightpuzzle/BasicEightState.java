package problem.basiceightpuzzle;

import problem.State;

public class BasicEightState implements State {

	private static final int BOARD_WIDTH  = 3;
	private static final int BOARD_HEIGHT = 3;
	
	private String [][] board;
	private int targetsXCoordinate;
	private int targetsYCoordinate;
	
	/**
	 * Default constructor.
	 */
	public BasicEightState(int xCoordinate, int yCoordinate) {
		this.targetsXCoordinate = xCoordinate;
		this.targetsYCoordinate = yCoordinate;
		this.board = new String [BOARD_WIDTH][BOARD_HEIGHT];
		for(int i = 0; i < BOARD_WIDTH; i++) {
			for(int j = 0; j < BOARD_HEIGHT; j++) {
				board[i][j] = "X";
			}
		}

		// only set the targets coordinates if they are valid.
		if(isValid()) {
			this.board[this.targetsYCoordinate][this.targetsXCoordinate] = "O";
		}
		
	}
	
	public int getTargetsXCoordinate() {
		return this.targetsXCoordinate;
	}
	
	public int getTargetsYCoordinate() {
		return this.targetsYCoordinate;
	}
	
	/**
	 * A basic eight board state is valid if the targets x and y coordinates are contained on the board.
	 * @return The boolean value representing whether the eight board state is valid.
	 */
	public boolean isValid() {
		return(((this.targetsXCoordinate >= 0) && (this.targetsXCoordinate < BOARD_WIDTH)) &&
			   ((this.targetsYCoordinate >= 0) && (this.targetsYCoordinate < BOARD_HEIGHT)));
	}
	
	/**
	 * Is this state equal to the other state?
	 * @param other The other state to check for equality.
	 * @return The boolean value representing whether the states are equivalent.
	 */
	public boolean equals(Object other) {
		if(other instanceof BasicEightState) {
			BasicEightState beState = ((BasicEightState)other);
			return((this.targetsXCoordinate == beState.getTargetsXCoordinate()) &&
				   (this.targetsYCoordinate == beState.getTargetsYCoordinate()));
		}
		return false;
	}
	
	/**
	 * Returns a string representation of the current board state.
	 */
	public String toString() {
		String boardString = new String("\n");		
		for(int i = 0; i < BOARD_HEIGHT; i++) {
			for(int j = 0; j < BOARD_WIDTH; j++) {
				boardString = boardString.concat("[" + this.board[i][j] +"] ");
			}
			boardString = boardString.concat("\n");
		}
		return boardString;
	}
	
	public int hashCode() {
		return(toString().hashCode());
	}
	
}

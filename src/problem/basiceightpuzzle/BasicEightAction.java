package problem.basiceightpuzzle;

import problem.Action;

public class BasicEightAction extends Action {

	public enum Direction {
		NORTH, SOUTH, EAST, WEST
	};

	private Direction direction;
		
	public BasicEightAction(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}	
	
	public String toString() {
		return this.direction.name();
	}
}

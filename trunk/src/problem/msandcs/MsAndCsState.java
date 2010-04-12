package problem.msandcs;

import problem.State;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MsAndCsState implements State {
	
	/* The two valid shores for this problem, LEFT and RIGHT */
	public static enum Shore {L, R};
	
	private Shore boatLocation;
	private ShoreState leftShoreState;
	private ShoreState rightShoreState;
	
	/**
	 * Constructor.
	 * @param boatLocation The current location of the boat, either LEFT or RIGHT.
	 * @param leftShoreMissionariesCount The number of missionaries on the LEFT shore.
	 * @param leftShoreCannibalsCount The number of cannibals on the LEFT shore.
	 * @param rightShoreMissionariesCount The number of missionaries on the RIGHT shore. 
	 * @param rightShoreCannibalsCount The number of cannibals on the RIGHT shore.
	 */
	public MsAndCsState(Shore boatLocation, int leftShoreMissionariesCount, int leftShoreCannibalsCount, 
			                             int rightShoreMissionariesCount, int rightShoreCannibalsCount) {
		this.boatLocation = boatLocation;
		this.leftShoreState    = new ShoreState(Shore.L, leftShoreMissionariesCount, leftShoreCannibalsCount);
		this.rightShoreState   = new ShoreState(Shore.R, rightShoreMissionariesCount, rightShoreCannibalsCount);
	}
	
	public ShoreState getLeftShoreState() {
		return leftShoreState;
	}

	public ShoreState getRightShoreState() {
		return rightShoreState;
	}
	
	public Shore getBoatLocation() {
		return boatLocation;
	}
	
	public boolean isValidState() {
		return (this.leftShoreState.isValid() && this.rightShoreState.isValid());
	}
	
	public String toString() {
		if(this.boatLocation.equals(Shore.L)) {
			return("(" + this.leftShoreState.toString() + " & Boat | " + this.rightShoreState.toString()+")");
		} else {
			return("(" + this.leftShoreState.toString() + " | " + this.rightShoreState.toString()+" & Boat)");
		}
	}
	
	public boolean equals(State other) {
		if(other instanceof MsAndCsState) {
			return((MsAndCsState)other).toString().equals(this.toString());
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 */
	static class ShoreState {
		
		public Shore shore;
		public int missionariesCount;
		public int cannibalsCount;
		
		public ShoreState(Shore shore, int missionariesCount, int cannibalsCount) {
			this.shore = shore;
			this.missionariesCount = missionariesCount;
			this.cannibalsCount = cannibalsCount;
		}
		
		public boolean isValid() {
			return((this.cannibalsCount <= this.missionariesCount) || (this.missionariesCount == 0));
		}
		
		public String toString() {
			return(shore + ": " + missionariesCount + "M & " + cannibalsCount + "C");
		}
	}
	
	
	
}



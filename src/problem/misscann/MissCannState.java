package problem.misscann;

import problem.State;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MissCannState implements State {
	
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
	public MissCannState(Shore boatLocation, int leftShoreMissionariesCount, int leftShoreCannibalsCount, 
			             int rightShoreMissionariesCount, int rightShoreCannibalsCount) {
		this.boatLocation      = boatLocation;
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
	
	public boolean isValid() {
		return (this.leftShoreState.isValid() && this.rightShoreState.isValid());
	}
	
	public String toString() {
		if(this.boatLocation.equals(Shore.L)) {
			return("| " + this.leftShoreState.toString() + " |<BOAT>~~~~~~| " + this.rightShoreState.toString() + " |");
		} else {
			return("| " + this.leftShoreState.toString() + " |~~~~~~<BOAT>| " + this.rightShoreState.toString() + " |");
		}
	}
	
	public boolean equals(Object other) {
		if(other instanceof MissCannState) {
			MissCannState mcState = ((MissCannState)other);
			return((mcState.getBoatLocation().equals(this.getBoatLocation())) && 
				   (mcState.getLeftShoreState().equals(this.getLeftShoreState())) &&
				   (mcState.getRightShoreState().equals(this.getRightShoreState())));
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return(this.toString().hashCode());
	}
	
	/**
	 * 
	 */
	public static class ShoreState {

		int missionariesCount;
		int cannibalsCount;
		
		ShoreState(Shore shore, int missionariesCount, int cannibalsCount) {
			this.missionariesCount = missionariesCount;
			this.cannibalsCount    = cannibalsCount;
		}
		
		/**
		 * A shore state is valid if there are less or an equal number of cannibals compared to missionaries on the shore.
		 * @return
		 */
		boolean isValid() {
			return(missionariesSafe() || cannibalsAlone());
		}
				   
		
		boolean missionariesSafe() {
			return(((this.cannibalsCount >= 0) && (this.missionariesCount > 0)) && (this.cannibalsCount <= this.missionariesCount));
		}
		
		boolean cannibalsAlone() {
			return((this.cannibalsCount > 0) && (this.missionariesCount == 0));
		}
		
		public boolean equals(Object other) {
			if(other instanceof ShoreState) {
				ShoreState otherSS = ((ShoreState)other);
				return((otherSS.cannibalsCount == this.cannibalsCount) && 
				       (otherSS.missionariesCount == this.missionariesCount));
			}
			return false;
		}
		
		public String toString() {
			return(missionariesCount + "M/" + cannibalsCount + "C");
		}
	}	
}



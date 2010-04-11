package problem.mandc;

import problem.State;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MissionariesAndCannibalsState implements State {

	public static enum Shore {LEFT, RIGHT};
	
	private Shore boatLocation;

	private ShoreState leftShore;
	private ShoreState rightShore;
	
	public MissionariesAndCannibalsState(Shore boatLocation, int leftShoreMissionariesCount, int leftShoreCannibalsCount, 
			                             int rightShoreMissionariesCount, int rightShoreCannibalsCount) {
		this.boatLocation = boatLocation;
		this.leftShore    = new ShoreState(Shore.LEFT, leftShoreMissionariesCount, leftShoreCannibalsCount);
		this.rightShore   = new ShoreState(Shore.RIGHT, rightShoreMissionariesCount, rightShoreCannibalsCount);
	}
	
	public Shore getBoatLocation() {
		return boatLocation;
	}
	
	public boolean isValidState() {
		return (this.leftShore.isValid() && this.rightShore.isValid());
	}
	
	/**
	 * 
	 */
	private static class ShoreState {
		
		Shore shore;
		int missionariesCount;
		int cannibalsCount;
		
		public ShoreState(Shore shore, int missionariesCount, int cannibalsCount) {
			this.shore = shore;
			this.missionariesCount = missionariesCount;
			this.cannibalsCount = cannibalsCount;
		}
		
		public boolean isValid() {
			return(!(this.cannibalsCount > this.missionariesCount));
		}
		
		public String toString() {
			return(shore + " shore: (" + missionariesCount + "M & " + cannibalsCount + "C)");
		}
	}
	
}



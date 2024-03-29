package problem.mapnavigation;

import problem.Action;
import problem.mapnavigation.MapNavigationState.RomanianCity;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MapNavigationAction extends Action {

	private RomanianCity moveFrom;
	private RomanianCity moveTo;
	private Integer distanceTravelled;
	
	/**
	 * Constructor.
	 * @param moveFrom
	 * @param moveTo
	 */
	public MapNavigationAction(RomanianCity moveFrom, RomanianCity moveTo) {
		this.moveFrom          = moveFrom;
		this.moveTo            = moveTo;
		this.distanceTravelled = moveFrom.getDistanceTo(moveTo);
	}
	
	public RomanianCity getMoveFrom() {
		return this.moveFrom;
	}
	
	public RomanianCity getMoveTo() {
		return this.moveTo;
	}
	
	public Integer getDistanceTravelled() {
		return this.distanceTravelled;
	}
	
	public String toString() {
		return(this.moveFrom.toString() + " --("+ this.distanceTravelled + "km)--> " + this.moveTo.toString());
	}
	
	
}

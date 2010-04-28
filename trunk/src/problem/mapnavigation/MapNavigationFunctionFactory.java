package problem.mapnavigation;

import java.util.ArrayList;
import java.util.List;

import problem.Action;
import problem.ActionsFunction;
import problem.ResultFunction;
import problem.State;
import problem.StepCostFunction;
import problem.mapnavigation.MapNavigationState.RomanianCity;
import problem.mapnavigation.MapNavigationState.RomanianCity.Location;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MapNavigationFunctionFactory {

	private static ResultFunction RESULT_FUNCTION      = null;
	private static ActionsFunction ACTIONS_FUNCTION    = null;
	private static StepCostFunction STEP_COST_FUNCTION = null;
	
	public static ResultFunction getResultFunction() {
		if(RESULT_FUNCTION == null) {
			RESULT_FUNCTION = new MapNavigationResultFunction();
		}
		return RESULT_FUNCTION;
	}
	
	public static ActionsFunction getActionsFunction() {
		if(ACTIONS_FUNCTION == null) {
			ACTIONS_FUNCTION = new MapNavigationActionsFunction();
		}
		return ACTIONS_FUNCTION;
	}
	
	public static StepCostFunction getStepCostFunction() {
		if(STEP_COST_FUNCTION == null) {
			STEP_COST_FUNCTION = new MapNavigationStepCostFunction();
		}
		return STEP_COST_FUNCTION;
	}
	
	/**
	 * 
	 * @author Brent Kersanske
	 *
	 */
	private static class MapNavigationResultFunction implements ResultFunction {

		public MapNavigationResultFunction () {			
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public State retrieveResult(State state, Action action) {
			MapNavigationState mnState = ((MapNavigationState)state);
			MapNavigationAction mnAction = ((MapNavigationAction)action);
			return new MapNavigationState(mnAction.getMoveTo(), mnState.getTotalDistanceTravelled() + mnAction.getDistanceTravelled());
		}		
	}
	
	/**
	 * 
	 * @author Brent Kersnaske
	 *
	 */
	private static class MapNavigationActionsFunction implements ActionsFunction {

		public MapNavigationActionsFunction() {			
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public List<Action> retrieveValidActions(State state) {
			MapNavigationState mnState = ((MapNavigationState)state);
			List<Action> validActions = new ArrayList<Action> ();
			for(Location connection : mnState.getCurrentLocation().getConnections()) {
				validActions.add(new MapNavigationAction(mnState.getCurrentLocation(), RomanianCity.getCity(connection)));
			}			
			return validActions;
		}		
	}
	
	/**
	 * 
	 * @author Brent Kersanske
	 *
	 */
	private static class MapNavigationStepCostFunction implements StepCostFunction {

		public MapNavigationStepCostFunction() {
		}
		
		@Override
		public double c(Object s, Action a, Object sPrime) {
			return 1.0d;
		}
		
	}
}

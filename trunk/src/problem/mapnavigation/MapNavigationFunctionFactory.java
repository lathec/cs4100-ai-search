package problem.mapnavigation;

import java.util.List;

import problem.Action;
import problem.ActionsFunction;
import problem.ResultFunction;
import problem.State;
import problem.StepCostFunction;

/**
 * 
 * @author Brent
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
			// TODO Auto-generated method stub
			return null;
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
		public List<Action> retrieveValidActions(State s) {
			// TODO Auto-generated method stub
			return null;
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
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}

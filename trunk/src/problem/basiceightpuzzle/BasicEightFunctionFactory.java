package problem.basiceightpuzzle;

import java.util.ArrayList;
import java.util.List;

import problem.Action;
import problem.ActionsFunction;
import problem.ResultFunction;
import problem.State;
import problem.StepCostFunction;
import problem.basiceightpuzzle.BasicEightAction.Direction;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class BasicEightFunctionFactory {

	private static ResultFunction RESULT_FUNCTION      = null;
	private static ActionsFunction ACTIONS_FUNCTION    = null;
	private static StepCostFunction STEP_COST_FUNCTION = null;
	
	public static ResultFunction getResultFunction() {
		if(RESULT_FUNCTION == null) {
			RESULT_FUNCTION = new BasicEightResultFunction();
		}
		return RESULT_FUNCTION;
	}
	
	public static ActionsFunction getActionsFunction() {
		if(ACTIONS_FUNCTION == null) {
			ACTIONS_FUNCTION = new BasicEightActionsFunction();
		}
		return ACTIONS_FUNCTION;
	}
	
	public static StepCostFunction getStepCostFunction() {
		if(STEP_COST_FUNCTION == null) {
			STEP_COST_FUNCTION = new BasicEightStepCostFunction();
		}
		return STEP_COST_FUNCTION;
	}
	
	/**
	 * Result function for the basic eight board problem.
	 * @author Brent Kersanske
	 */
	private static class BasicEightResultFunction implements ResultFunction {

		public BasicEightResultFunction() {			
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public State retrieveResult(State state, Action action) {
			BasicEightState beState = ((BasicEightState)state);
			BasicEightAction beAction = ((BasicEightAction)action);
			if(beAction.getDirection().equals(Direction.EAST)) {
				return new BasicEightState(beState.getTargetsXCoordinate() + 1, beState.getTargetsYCoordinate());
			} else if(beAction.getDirection().equals(Direction.NORTH)) {
				return new BasicEightState(beState.getTargetsXCoordinate(), beState.getTargetsYCoordinate() - 1);
			} else if(beAction.getDirection().equals(Direction.SOUTH)) {
				return new BasicEightState(beState.getTargetsXCoordinate(), beState.getTargetsYCoordinate() + 1);
			} else {
				return new BasicEightState(beState.getTargetsXCoordinate() - 1, beState.getTargetsYCoordinate());
			}			
		}		
	}
	
	/**
	 * The Actions function for the basic eight board problem.
	 * @author Brent Kersanske
	 */
	private static class BasicEightActionsFunction implements ActionsFunction {

		private static BasicEightAction MOVE_EAST  = new BasicEightAction(Direction.EAST);
		private static BasicEightAction MOVE_NORTH = new BasicEightAction(Direction.NORTH);
		private static BasicEightAction MOVE_SOUTH = new BasicEightAction(Direction.SOUTH);
		private static BasicEightAction MOVE_WEST  = new BasicEightAction(Direction.WEST);
		private static List<BasicEightAction> ALL_POSSIBLE_ACTIONS = new ArrayList<BasicEightAction> ();
		
		static {
			ALL_POSSIBLE_ACTIONS.add(MOVE_EAST);
			ALL_POSSIBLE_ACTIONS.add(MOVE_NORTH);
			ALL_POSSIBLE_ACTIONS.add(MOVE_SOUTH);
			ALL_POSSIBLE_ACTIONS.add(MOVE_WEST);
		}
		
		public BasicEightActionsFunction() {			
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public List<Action> retrieveValidActions(State s) {
			List<Action> validActions = new ArrayList<Action> ();
			for(Action action : ALL_POSSIBLE_ACTIONS) {
				if(((BasicEightState)getResultFunction().retrieveResult(s, action)).isValid()) {
					validActions.add(action);
				}
			}
			return validActions;
		}		
	}	
	
	/**
	 * The Step cost function for the basic eight puzzle.
	 * @author Brent Kersanske
	 *
	 */
	private static class BasicEightStepCostFunction implements StepCostFunction {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public double c(Object s, Action a, Object sPrime) {
			return 1;
		}		
	}
}

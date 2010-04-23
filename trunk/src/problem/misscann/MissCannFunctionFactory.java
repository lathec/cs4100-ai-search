package problem.misscann;

import java.util.ArrayList;
import java.util.List;

import problem.Action;
import problem.ActionsFunction;
import problem.ResultFunction;
import problem.State;
import problem.StepCostFunction;
import problem.misscann.MissCannState.Shore;

/**
 * Function factory for the missionaries and cannibals problem.
 * @author Brent Kersanske
 *
 */
public class MissCannFunctionFactory {

	private static ResultFunction RESULT_FUNCTION = null;
	private static ActionsFunction ACTIONS_FUNCTION = null;
	private static StepCostFunction STEP_COST_FUNCTION = null;
	
	public static ResultFunction getResultFunction() {
		if(RESULT_FUNCTION == null) {
			RESULT_FUNCTION = new MissCannResultFunction();
		}
		return RESULT_FUNCTION;
	}
	
	public static ActionsFunction getActionsFunction() {
		if(ACTIONS_FUNCTION == null) {
			ACTIONS_FUNCTION = new MissCannActionsFunction();
		}
		return ACTIONS_FUNCTION;
	}
	
	public static StepCostFunction getStepCostFunction() {
		if(STEP_COST_FUNCTION == null) {
			STEP_COST_FUNCTION = new MissCannStepCostFunction();
		}
		return STEP_COST_FUNCTION;
	}
	
	/**
	 * Result function for the missionaries and cannibals problem.
	 * @author Brent Kersanske
	 */
	private static class MissCannResultFunction implements ResultFunction {
		public MissCannResultFunction() {			
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public State retrieveResult(State state, Action action) {
			MissCannState mcState   = ((MissCannState)state);
			MissCannAction mcAction = ((MissCannAction)action);
			if(mcState.getBoatLocation().equals(Shore.L)) {
				return new MissCannState(Shore.R,
										 mcState.getLeftShoreState().missionariesCount  - mcAction.getNumMissionariesToTransport(),
										 mcState.getLeftShoreState().cannibalsCount     - mcAction.getNumCannibalsToTransport(),
										 mcState.getRightShoreState().missionariesCount + mcAction.getNumMissionariesToTransport(),
										 mcState.getRightShoreState().cannibalsCount    + mcAction.getNumCannibalsToTransport());
			} else {
				return new MissCannState(Shore.L,
										 mcState.getLeftShoreState().missionariesCount  + mcAction.getNumMissionariesToTransport(),
										 mcState.getLeftShoreState().cannibalsCount     + mcAction.getNumCannibalsToTransport(),
										 mcState.getRightShoreState().missionariesCount - mcAction.getNumMissionariesToTransport(),
										 mcState.getRightShoreState().cannibalsCount    - mcAction.getNumCannibalsToTransport());
			}
		}
	}
	
	/**
	 * Action function for the missionaries and cannibals problem.
	 * @author Brent
	 *
	 */
	private static class MissCannActionsFunction implements ActionsFunction {
		
		private static MissCannAction TWO_Ms_CROSS      = new MissCannAction(2, 0, "Two missionaries cross.");
		private static MissCannAction TWO_Cs_CROSS      = new MissCannAction(0, 2, "Two cannibals cross.");
		private static MissCannAction ONE_M_ONE_C_CROSS = new MissCannAction(1, 1, "One missionary and one cannibal cross.");
		private static MissCannAction ONE_M_CROSS       = new MissCannAction(1, 0, "One missionary crosses.");
		private static MissCannAction ONE_C_CROSS		= new MissCannAction(0, 1, "One cannibal crosses.");	
		private static List<MissCannAction> ALL_POSSIBLE_ACTIONS = new ArrayList<MissCannAction> ();
		
		static {
			ALL_POSSIBLE_ACTIONS.add(TWO_Ms_CROSS);
			ALL_POSSIBLE_ACTIONS.add(TWO_Cs_CROSS);
			ALL_POSSIBLE_ACTIONS.add(ONE_M_ONE_C_CROSS);
			ALL_POSSIBLE_ACTIONS.add(ONE_M_CROSS);
			ALL_POSSIBLE_ACTIONS.add(ONE_C_CROSS);
		}
		
		public MissCannActionsFunction() {			
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public List<Action> retrieveValidActions(State state) {
			List<Action> validActions = new ArrayList<Action> ();
			for(Action action : ALL_POSSIBLE_ACTIONS) {
				if(((MissCannState)getResultFunction().retrieveResult(state, action)).isValid()) {
					validActions.add(action);
				}
			} 
			return validActions;
		}
	}
	
	/**
	 * The step cost function for the missionaries and cannibals problem.
	 * @author Brent Kersanske
	 */
	private static class MissCannStepCostFunction implements StepCostFunction {

		@Override
		public double c(Object s, Action a, Object sPrime) {
			return 1.0d;
		}		
	}
}

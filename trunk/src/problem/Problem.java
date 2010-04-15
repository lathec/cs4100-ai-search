package problem;

import java.util.List;



public abstract class Problem {

	protected ActionsFunction actionsFunction;
	
	protected ResultFunction resultFunction;
	
	protected State initialState;
	
	protected State goalState;
	
	public boolean isGoalState(State state) {
		return state.equals(goalState);
	}
	
	public State getInitialState() {
		return this.initialState;
	}
	
	abstract public List<Action> retrieveAcceptableActionsFromState(State state);

	abstract public State retrieveResult(State state, Action action);
	
	abstract public double retrievePathCost(State state, Action action);
	
}
 
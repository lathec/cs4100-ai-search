package problem;

import java.util.List;

/**
 * 
 * @author Brent Kersanske
 *
 */
public abstract class Problem {

	protected ActionsFunction actionsFunction;	
	protected ResultFunction resultFunction;	
	protected StepCostFunction stepCostFunction;
	protected State initialState;
    protected State goalState;
	
	public boolean isGoalState(State state) {
		return state.equals(goalState);
	}
	
	public State getGoalState() {
		return this.goalState;
	}
	
	public State getInitialState() {
		return this.initialState;
	}
	
	public ActionsFunction getActionsFunction() {
		return this.actionsFunction;
	}
	
	public ResultFunction getResultFunction() {
		return this.resultFunction;
	}
	
	public StepCostFunction getStepCostFunction() {
		return this.stepCostFunction;
	}
	
	abstract public List<Action> retrieveAcceptableActionsFromState(State state);

	abstract public State retrieveResult(State state, Action action);
	
	abstract public double retrievePathCost(State state, Action action);
	
}
 
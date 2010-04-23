package problem.basiceightpuzzle;

import java.util.List;

import problem.Action;
import problem.Problem;
import problem.State;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class BasicEightProblem extends Problem {

	public BasicEightProblem(State initialState, State goalState) {
		this.initialState     = initialState;
		this.goalState        = goalState;
		this.actionsFunction  = BasicEightFunctionFactory.getActionsFunction();
		this.resultFunction   = BasicEightFunctionFactory.getResultFunction();
		this.stepCostFunction = BasicEightFunctionFactory.getStepCostFunction();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Action> retrieveAcceptableActionsFromState(State state) {
		return this.actionsFunction.retrieveValidActions(state);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double retrievePathCost(State state, Action action) {
		return 1.0d;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public State retrieveResult(State state, Action action) {
		return resultFunction.retrieveResult(state, action);
	}

	public String toString() {
		return("Basic Eight Puzzle Problem");
	}
}

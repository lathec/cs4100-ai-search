package problem.mapnavigation;

import java.util.List;

import problem.Action;
import problem.Problem;
import problem.State;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MapNavigationProblem extends Problem {

	public MapNavigationProblem(State initialState, State goalState) {
		this.initialState     = initialState;
		this.goalState        = goalState;
		this.actionsFunction  = MapNavigationFunctionFactory.getActionsFunction();
		this.resultFunction   = MapNavigationFunctionFactory.getResultFunction();
		this.stepCostFunction = MapNavigationFunctionFactory.getStepCostFunction();
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
		return this.stepCostFunction.c(state, action, this.resultFunction.retrieveResult(state, action));
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

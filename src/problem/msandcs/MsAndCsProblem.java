package problem.msandcs;

import java.util.List;

import problem.Action;
import problem.Problem;
import problem.State;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MsAndCsProblem extends Problem {
	
	public MsAndCsProblem(State initialState, State goalState) {
		this.initialState = initialState;
		this.goalState    = goalState;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Action> retrieveAcceptableActionsFromState(State state) {
		return MsAndCsAction.retrieveValidActionsFromState(((MsAndCsState)state));
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
		return((MsAndCsAction)action).getEndState(((MsAndCsState)state));
	}
}

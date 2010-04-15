package problem.misscann;

import java.util.ArrayList;
import java.util.List;

import problem.Action;
import problem.Problem;
import problem.State;
import search.Node;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MissCannProblem extends Problem {
		
	public MissCannProblem(State initialState, State goalState) {
		this.initialState    = initialState;
		this.goalState       = goalState;
		this.actionsFunction = MissCannFunctionFactory.getActionsFunction();
		this.resultFunction  = MissCannFunctionFactory.getResultFunction();		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Action> retrieveAcceptableActionsFromState(State state) {
		return this.actionsFunction.retrieveValidActions(state);
	}

	public List<Node> generateSuccessors(Node parentNode) {
		List<Node> validSuccessors = new ArrayList<Node> ();
		List<Action> validActions = retrieveAcceptableActionsFromState(parentNode.getState());
		for(Action validAction : validActions) {
			Node successor = new Node(retrieveResult(parentNode.getState(), validAction), 
					                   parentNode, 
					                   validAction, 
					                   retrievePathCost(parentNode.getState(), validAction));
			validSuccessors.add(successor);
		}
		return validSuccessors;
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
}

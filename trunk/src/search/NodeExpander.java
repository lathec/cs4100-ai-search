package search;

import java.util.ArrayList;
import java.util.List;

import problem.Action;
import problem.ActionsFunction;
import problem.Problem;
import problem.ResultFunction;
import problem.State;
import problem.StepCostFunction;


/**
 * @see aima.core.search.framework.NodeExpander
 */
public class NodeExpander {
	
	private int nodesExpanded;

	public NodeExpander() {
		this.nodesExpanded = 0;
	}

	public void clearInstrumentation() {
		this.nodesExpanded = 0;
	}

	public int getNodesExpanded() {
		return this.nodesExpanded;
	}

	public List<Node> expandNode(Node node, Problem problem) {		
		List<Node> childNodes             = new ArrayList<Node>();
		ActionsFunction actionsFunction   = problem.getActionsFunction();
		ResultFunction resultFunction     = problem.getResultFunction();
		StepCostFunction stepCostFunction = problem.getStepCostFunction();
		for(Action action : actionsFunction.retrieveValidActions(node.getState())) {
			State successorState = resultFunction.retrieveResult(node.getState(), action);
			double stepCost = stepCostFunction.c(node.getState(), action, successorState);
			childNodes.add(new Node(successorState, node, action, stepCost));
		}
		this.nodesExpanded = this.nodesExpanded + 1;
		return childNodes;
	}
}
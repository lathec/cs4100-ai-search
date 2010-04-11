package search;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

import problem.Action;
import problem.Problem;
import problem.State;

/**
 * Abstract class for extension by various search algorithms.
 * Mostly taken from the aima.core package, with some custom modifications for simplification.
 * @author Brent Kersanske
 *
 */
public abstract class Search {

	protected HashSet<State> exploredNodes;
	
	protected HashMap<State, Node> currentFrontierState;
	
	protected Queue<Node> frontier;
	
	protected ArrayList<Node> addToFrontier;
	
	/**
	 * 
	 * @param problem
	 * @param frontier
	 * @return
	 */
	public List<Action> search(Problem problem, Queue<Node> frontier) {		
		Node rootNode = new Node(problem.getInitialState());		
		if(problem.isGoalState(rootNode.getState())) {
			return retrieveActionsFromNodes(rootNode.getNodePathFromRoot());
		}
		frontier.add(rootNode);		
		while(!(frontier.isEmpty())) {
			Node nodeToExpand = frontier.poll();
			if(problem.isGoalState(nodeToExpand.getState())) {
				return retrieveActionsFromNodes(nodeToExpand.getNodePathFromRoot());
			}
			for(Node frontierNode : retrieveResultingNodesToAddToFrontier(nodeToExpand, problem)) {
				if(problem.isGoalState(frontierNode.getState())) {
					return retrieveActionsFromNodes(nodeToExpand.getNodePathFromRoot());
				}
				frontier.add(frontierNode);
			}
		}		
		return new ArrayList<Action> ();		
	}
	
	/**
	 * 
	 * @param nodeList
	 * @return
	 */
	private List<Action> retrieveActionsFromNodes(List<Node> nodeList) {
		List<Action> actions = new ArrayList<Action>();
		if(nodeList.size() == 1) {
			// TODO: fix this
			actions.add(null);
		} else {
			for(int i = 1; i < nodeList.size(); i++) {
				Node node = nodeList.get(i);
				actions.add(node.getAction());
			}
		}
		return actions;
	}
	
	/**
	 * 
	 * @param node
	 * @param problem
	 * @return
	 */
	protected List<Node> expandNode(Node node, Problem problem) {
		List<Node> childNodes = new ArrayList<Node> ();		
		for(Action action : problem.retrieveAcceptableActionsFromState(node.getState())) {
			State successorState = problem.retrieveResult(node.getState(), action);
			double pathCost      = problem.retrievePathCost(node.getState(), action);
			childNodes.add(new Node(successorState, node, action, pathCost));
		}
		return childNodes;
	}
	
	protected abstract List<Node> retrieveResultingNodesToAddToFrontier(Node nodeToExpand, Problem problem);
	
}

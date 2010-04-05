import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

/**
 * Abstract class for extension by various search algorithms.
 * Mostly taken from the aima.core package, with some custom modifications for simplification.
 * @author Brent Kersanske
 *
 */
public abstract class Search {

	protected HashSet<Node> exploredNodes;
	
	protected HashMap<State, Node> currentFrontierState;
	
	protected Queue<Node> frontier;
	
	protected ArrayList<Node> addToFrontier;
	
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
	
	protected abstract List<Node> retrieveResultingNodesToAddToFrontier(Node nodeToExpand, Problem problem);
	
}

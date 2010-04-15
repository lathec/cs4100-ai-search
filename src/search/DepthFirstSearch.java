package search;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import problem.Problem;
import problem.State;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class DepthFirstSearch extends Search {

	public DepthFirstSearch() {
		this.addToFrontier        = new ArrayList<Node>();
		this.exploredNodes        = new HashSet<State> ();
		this.currentFrontierState = new HashMap<State, Node> ();
		this.frontier			  = new LinkedList<Node> ();
	}
	
	@Override
	protected List<Node> retrieveResultingNodesToAddToFrontier(Node nodeToExpand, Problem problem) {
		this.addToFrontier.clear();
		this.exploredNodes.add(nodeToExpand.getState());
		for(Node node : expandNode(nodeToExpand, problem)) {
			Node frontierNode = this.currentFrontierState.get(node.getState());
			if((frontierNode == null) && (!this.exploredNodes.contains(node.getState()))) {
				addToFrontier.add(node);
			}
		}
		return this.addToFrontier;
	}
}

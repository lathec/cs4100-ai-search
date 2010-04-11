package search;
import java.util.List;

import problem.Problem;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class DepthFirstSearch extends Search {

	@Override
	protected List<Node> retrieveResultingNodesToAddToFrontier(Node nodeToExpand, Problem problem) {
		this.addToFrontier.clear();
		this.exploredNodes.add(nodeToExpand.getState());
		for(Node node : expandNode(nodeToExpand, problem)) {
			Node frontierNode = this.currentFrontierState.get(node.getState());
			if(notInFrontierOrExploredSet(frontierNode)) {
				addToFrontier.add(frontierNode);
			}
		}
		return this.addToFrontier;
	}
	
	protected boolean notInFrontierOrExploredSet(Node node) {
		return((node != null) && (!this.exploredNodes.contains(node.getState())));
	}

}

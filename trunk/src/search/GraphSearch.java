package search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import problem.Action;
import problem.Problem;
import problem.State;

/**
 * @see aima.core.search.framework.GraphSearch
 */
public class GraphSearch extends QueueSearch {

	protected Set<State> exploredNodes  = new HashSet<State>();
	protected Map<Object, Node> frontierState = new HashMap<Object, Node>();
	protected Comparator<Node> replaceFrontierNodeAtStateCostFunction = null;
	protected List<Node> nodesToAddToFrontier = new ArrayList<Node>();

	public Comparator<Node> getReplaceFrontierNodeAtStateCostFunction() {
		return replaceFrontierNodeAtStateCostFunction;
	}

	public void setReplaceFrontierNodeAtStateCostFunction(Comparator<Node> replaceFrontierNodeAtStateCostFunction) {
		this.replaceFrontierNodeAtStateCostFunction = replaceFrontierNodeAtStateCostFunction;
	}

	// Need to override search() method so that I can re-initialize
	// the explored set should multiple calls to search be made.
	@Override
	public List<Action> search(Problem problem) {
		exploredNodes.clear();
		frontierState.clear();
		return super.search(problem);
	}

	@Override
	public Node popNodeFromFrontier() {
		Node toRemove = super.popNodeFromFrontier();
		frontierState.remove(toRemove.getState());
		return toRemove;
	}

	@Override
	public boolean removeNodeFromFrontier(Node toRemove) {
		boolean removed = super.removeNodeFromFrontier(toRemove);
		if (removed) {
			frontierState.remove(toRemove.getState());
		}
		return removed;
	}

	@Override
	public List<Node> getResultingNodesToAddToFrontier(Node nodeToExpand, Problem problem) {		
		nodesToAddToFrontier.clear();
		exploredNodes.add(nodeToExpand.getState());
		for(Node chosenFrontierNode : expandNode(nodeToExpand, problem)) {
			Node frontierNode = frontierState.get(chosenFrontierNode.getState());
			boolean addToFrontier = false;
			// only if not in the frontier or explored set
			boolean alreadyExplored = exploredNodes.contains(chosenFrontierNode.getState());
			if (null == frontierNode && !alreadyExplored) {
				addToFrontier = true;
			} else if (null != frontierNode
					&& null != replaceFrontierNodeAtStateCostFunction
					&& replaceFrontierNodeAtStateCostFunction.compare(chosenFrontierNode,
							frontierNode) < 0) {
				// child.STATE is in frontier with higher cost
				// replace that frontier node with child
				addToFrontier = true;
				// Want to replace the current frontier node with the child
				// node therefore mark the child to be added and remove the
				// current fontierNode
				removeNodeFromFrontier(frontierNode);
				// Ensure removed from add to frontier as well
				// as 1 or more may reach the same state at the same time
				nodesToAddToFrontier.remove(frontierNode);
			}

			if(addToFrontier) {
				nodesToAddToFrontier.add(chosenFrontierNode);
				frontierState.put(chosenFrontierNode.getState(), chosenFrontierNode);
			}
		}

		return nodesToAddToFrontier;
	}
}
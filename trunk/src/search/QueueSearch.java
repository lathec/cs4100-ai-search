package search;

import java.util.Collections;
import java.util.List;

import problem.Action;
import problem.Problem;

import datastructure.Queue;

/**
 * @see aima.core.search.framework.QueueSearch
 */
public abstract class QueueSearch extends NodeExpander {
	
	protected int queueSize;
	protected int maxQueueSize;
	protected double pathCost;
	protected Queue<Node> frontier = null;

	public boolean isFailure(List<Action> result) {
		return 0 == result.size();
	}

	/**
	 * 
	 * @param problem
	 * @param frontier
	 * @return if goal found, the list of actions to the Goal. If already at the
	 *         goal you will receive a List with a single NoOp Action in it. If
	 *         fail to find the Goal, an empty list will be returned to indicate
	 *         that the search failed.
	 */
	public List<Action> search(Problem problem) {		
		clearInstrumentation();
		// initialize the frontier using the initial state of the problem
		Node root = new Node(problem.getInitialState());
		if (problem.isGoalState(root.getState())) {
			return SearchUtils.actionsFromNodes(root.getNodePathFromRoot());
		}
		frontier.insert(root);
		setQueueSize(frontier.size());
		while (!frontier.isEmpty()) {
			// choose a leaf node and remove it from the frontier
			Node nodeToExpand = popNodeFromFrontier();
			setQueueSize(frontier.size());
			for(Node frontierNode : getResultingNodesToAddToFrontier(nodeToExpand, problem)) {
				if(problem.isGoalState(frontierNode.getState())) {
					return SearchUtils.actionsFromNodes(frontierNode.getNodePathFromRoot());
				}
				frontier.insert(frontierNode);
			}
			setQueueSize(frontier.size());
		}
		// if the frontier is empty then return failure
		return failure();
	}

	public Node popNodeFromFrontier() {
		return frontier.pop();
	}

	public boolean removeNodeFromFrontier(Node toRemove) {
		return frontier.remove(toRemove);
	}

	public abstract List<Node> getResultingNodesToAddToFrontier(
			Node nodeToExpand, Problem p);

	@Override
	public void clearInstrumentation() {
		super.clearInstrumentation();
		this.queueSize    = 0;
		this.maxQueueSize = 0;
		this.pathCost     = 0.0d;
	}

	public int getQueueSize() {
		return this.queueSize;
	}

	public void setQueueSize(int queueSize) {
		this.queueSize = queueSize;
		if (queueSize > maxQueueSize) {
			this.maxQueueSize = queueSize;
		}
	}

	public int getMaxQueueSize() {
		return this.maxQueueSize;
	}

	public double getPathCost() {
		return this.pathCost;
	}

	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
	}

	private List<Action> failure() {
		return Collections.emptyList();
	}
}
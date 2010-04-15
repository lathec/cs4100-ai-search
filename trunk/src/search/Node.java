package search;
import java.util.ArrayList;
import java.util.List;

import problem.Action;
import problem.Problem;
import problem.State;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class Node {
	
	private State state;
	
	private Node parent;
	
	private Action action;
	
	private double pathCost;
	
	/**
	 * Constructor for a root node.
	 */
	public Node(State state) {
		this.state    = state;
		this.pathCost = 0.0d;
	}
	
	/**
	 * Default constructor. Constructs a node with the given state, parent, and action.
	 * @param state The state in the state space to which the node corresponds.
	 * @param parent The node in the search tree that generated this node.
	 * @param action The action that was applied to the parent to generate the ndoe.
	 */
	public Node(State state, Node parent, Action action, double pathCost) {
		this.state    = state;
		this.parent   = parent;
		this.action   = action;
		this.pathCost = parent.getPathCost() + pathCost;
	}
	
	public State getState() {
		return state;
	}

	public Node getParent() {
		return parent;
	}

	public Action getAction() {
		return action;
	}

	public double getPathCost() {
		return pathCost;
	}

	/**
	 * 
	 * @param problem
	 * @param parent
	 * @param action
	 * @return
	 */
	public Node generateChildNode(Problem problem, Node parent, Action action) {
		return null;
	}

	
	public boolean isRootNode() {
		return this.parent == null;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Node> getNodePathFromRoot() {
		
		List<Node> pathFromRoot = new ArrayList<Node> ();
		Node currentNode = this;
		
		while(!currentNode.isRootNode()) {
			pathFromRoot.add(0, currentNode);
			currentNode = currentNode.getParent();
		}
		
		pathFromRoot.add(0, currentNode);
		return pathFromRoot;
	}
	
	public String toString() {
		return state.toString();
	}
}

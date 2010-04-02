
public class Node {
	
	private State state;
	
	private Node parent;
	
	private Action action;
	
	private int pathCost;
	
	/**
	 * 
	 */
	public Node() {
		
	}
	
	/**
	 * Default constructor. Constructs a node with the given state, parent, and action.
	 * @param state The state in the state space to which the node corresponds.
	 * @param parent The node in the search tree that generated this node.
	 * @param action The action that was applied to the parent to generate the ndoe.
	 */
	public Node(State state, Node parent, Action action) {
		this.state  = state;
		this.parent = parent;
		this.action = action;
	}

	/**
	 * 
	 * @param problem
	 * @param parent
	 * @param action
	 * @return
	 */
	public Node generateChildNode(Problem problem, Node parent, Action action) {
		Node childNode = new Node();
	}

}

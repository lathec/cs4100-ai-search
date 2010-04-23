package search;

import datastructure.LastInFirstOutQueue;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class DepthFirstSearch extends GraphSearch {

	public DepthFirstSearch() {
		this.frontier = new LastInFirstOutQueue<Node> ();
	}
}

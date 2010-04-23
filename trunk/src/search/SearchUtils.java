package search;

import java.util.ArrayList;
import java.util.List;

import problem.Action;

/**
 * @see aima.core.search.framework.SearchUtils
 * 
 */
public class SearchUtils {

	public static List<Action> actionsFromNodes(List<Node> nodeList) {
		List<Action> actions = new ArrayList<Action>();
		if(nodeList.size() > 1) {
			for (int i = 1; i < nodeList.size(); i++) {
				Node node = nodeList.get(i);
				actions.add(node.getAction());
			}
		}
		return actions;
	}
}
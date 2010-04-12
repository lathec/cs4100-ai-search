package problem;

import java.util.LinkedList;
import java.util.List;

import problem.msandcs.MsAndCsProblem;
import problem.msandcs.MsAndCsState;
import problem.msandcs.MsAndCsState.Shore;
import search.DepthFirstSearch;
import search.Node;

public class ProblemRunner {

	public static void main(String[] args) {
		MsAndCsState mAndCInitialState = new MsAndCsState(Shore.R, 0, 0, 3, 3);
		MsAndCsState mAndCGoalState    = new MsAndCsState(Shore.L, 3, 3, 0, 0);
		MsAndCsProblem missionariesAndCannibals = new MsAndCsProblem(mAndCInitialState, mAndCGoalState);
		
		DepthFirstSearch DFS = new DepthFirstSearch();
		List<Action> actionsOfSearch = DFS.search(missionariesAndCannibals, new LinkedList<Node> ());
		for(Action action : actionsOfSearch) {
			System.out.println(action.toString());
		}
		
	}
}

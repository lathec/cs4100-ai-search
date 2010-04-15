package problem;

import java.util.LinkedList;
import java.util.List;

import problem.misscann.MissCannProblem;
import problem.misscann.MissCannState;
import problem.misscann.MissCannState.Shore;
import search.DepthFirstSearch;
import search.Node;

public class ProblemRunner {

	public static void main(String[] args) {
		MissCannState mAndCInitialState = new MissCannState(Shore.R, 0, 0, 3, 3);
		MissCannState mAndCGoalState    = new MissCannState(Shore.L, 3, 3, 0, 0);
		MissCannProblem missionariesAndCannibals = new MissCannProblem(mAndCInitialState, mAndCGoalState);
		
		DepthFirstSearch DFS = new DepthFirstSearch();
		List<Action> actionsOfSearch = DFS.search(missionariesAndCannibals, new LinkedList<Node> ());
		for(Action action : actionsOfSearch) {
			System.out.println(action.toString());
		}
		
	}
}

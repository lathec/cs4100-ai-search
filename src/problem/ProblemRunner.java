package problem;

import java.util.List;

import problem.basiceightpuzzle.BasicEightProblem;
import problem.basiceightpuzzle.BasicEightState;
import problem.misscann.MissCannProblem;
import problem.misscann.MissCannState;
import problem.misscann.MissCannState.Shore;
import search.DepthFirstSearch;
import search.GraphSearch;

public class ProblemRunner {

	public static void main(String[] args) {
		
		MissCannState mAndCInitialState = new MissCannState(Shore.R, 0, 0, 3, 3);
		MissCannState mAndCGoalState    = new MissCannState(Shore.L, 3, 3, 0, 0);
		MissCannProblem missionariesAndCannibals = new MissCannProblem(mAndCInitialState, mAndCGoalState);
		
		BasicEightState beInitialState = new BasicEightState(0, 0);
		BasicEightState beGoalState    = new BasicEightState(2, 2);
		BasicEightProblem basicEightBoardPuzzle = new BasicEightProblem(beInitialState, beGoalState);
		
		DepthFirstSearch DFS = new DepthFirstSearch();
		runAndPrintSearch(DFS, basicEightBoardPuzzle);
		runAndPrintSearch(DFS, missionariesAndCannibals);
	}
	
	private static void runAndPrintSearch(GraphSearch searcher, Problem problem) {
		List<Action> actionsOfSearch = searcher.search(problem);
		System.out.println("Result of " + problem.toString());
		System.out.println("\nInitial State " + problem.getInitialState().toString());
		for(int i = 0; i < actionsOfSearch.size(); i++) {
			Action action = actionsOfSearch.get(i);
			System.out.println((i + 1) + " " + action.toString());
		}		
		System.out.println("\nGoal State" + problem.getGoalState());
	}
}

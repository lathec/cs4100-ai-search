
public class Problem {

	private State initialState;
	
	private State goalState;
	
	public boolean isGoalState(State state) {
		return state.equals(goalState);
	}
	
}
 
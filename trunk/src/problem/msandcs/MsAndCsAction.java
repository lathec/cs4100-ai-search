package problem.msandcs;

import java.util.ArrayList;
import java.util.List;

import problem.Action;
import problem.msandcs.MsAndCsState.Shore;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MsAndCsAction extends Action {

	public static MsAndCsAction TWO_Ms_CROSS      = new MsAndCsAction(2, 0, "Two missionaries cross.");
	public static MsAndCsAction TWO_Cs_CROSS      = new MsAndCsAction(0, 2, "Two cannibals cross.");
	public static MsAndCsAction ONE_M_ONE_C_CROSS = new MsAndCsAction(1, 1, "One missionary and one cannibal cross.");
	public static MsAndCsAction ONE_M_CROSS       = new MsAndCsAction(1, 0, "One missionary crosses.");
	public static MsAndCsAction ONE_C_CROSS		  = new MsAndCsAction(0, 1, "One cannibal crosses.");	
	public static List<MsAndCsAction> ALL_POSSIBLE_ACTIONS = new ArrayList<MsAndCsAction> ();
	
	static {
		ALL_POSSIBLE_ACTIONS.add(TWO_Ms_CROSS);
		ALL_POSSIBLE_ACTIONS.add(TWO_Cs_CROSS);
		ALL_POSSIBLE_ACTIONS.add(ONE_M_ONE_C_CROSS);
		ALL_POSSIBLE_ACTIONS.add(ONE_M_CROSS);
		ALL_POSSIBLE_ACTIONS.add(ONE_C_CROSS);
	}
	
	private int numMissionariesToTransport;
	private int numCannibalsToTransport;
	private String description;
	
	/**
	 * Constructor.
	 * @param numMissionariesToTransport
	 * @param numCannibalsToTransport
	 */
	public MsAndCsAction(int numMissionariesToTransport, int numCannibalsToTransport, String description) {
		this.numMissionariesToTransport = numMissionariesToTransport;
		this.numCannibalsToTransport    = numCannibalsToTransport;
		this.description				= description;
	}
	
	/**
	 * 
	 * @return
	 */
	public MsAndCsState getEndState(MsAndCsState startingState) {
		if(startingState.getBoatLocation().equals(Shore.L)) {			
			return new MsAndCsState(Shore.R, 
								   (startingState.getLeftShoreState().missionariesCount  - this.numMissionariesToTransport),
								   (startingState.getLeftShoreState().cannibalsCount     - this.numCannibalsToTransport),
								   (startingState.getRightShoreState().missionariesCount + this.numMissionariesToTransport),
								   (startingState.getRightShoreState().cannibalsCount    + this.numCannibalsToTransport));			
		} else {
			return new MsAndCsState(Shore.L,
								   (startingState.getLeftShoreState().missionariesCount  + this.numMissionariesToTransport),
								   (startingState.getLeftShoreState().cannibalsCount     + this.numCannibalsToTransport),
								   (startingState.getRightShoreState().missionariesCount - this.numMissionariesToTransport),
								   (startingState.getRightShoreState().cannibalsCount    - this.numCannibalsToTransport));	
		}		
	}
	
	/**
	 * Gets all valid actions from the given state.
	 * @param state
	 * @return
	 */
	public static List<Action> retrieveValidActionsFromState(MsAndCsState state) {
		List<Action> validActions = new ArrayList<Action> ();
		for(MsAndCsAction action : ALL_POSSIBLE_ACTIONS) {			
			if(action.getEndState(state).isValidState()) {
				validActions.add(action);
			}
		}
		return validActions;
	}
	
	public String toString() {
		return this.description;
	}
}

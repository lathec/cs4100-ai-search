package problem.misscann;

import problem.Action;

/**
 * 
 * @author Brent Kersanske
 *
 */
public class MissCannAction extends Action {

	private int numMissionariesToTransport;
	private int numCannibalsToTransport;
	private String description;
	
	/**
	 * Constructor.
	 * @param numMissionariesToTransport
	 * @param numCannibalsToTransport
	 */
	public MissCannAction(int numMissionariesToTransport, int numCannibalsToTransport, String description) {
		this.numMissionariesToTransport = numMissionariesToTransport;
		this.numCannibalsToTransport    = numCannibalsToTransport;
		this.description				= description;
	}

	public int getNumMissionariesToTransport() {
		return numMissionariesToTransport;
	}

	public int getNumCannibalsToTransport() {
		return numCannibalsToTransport;
	}
	
	public String toString() {
		return this.description;
	}
}

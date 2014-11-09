package me.planetguy.endgamerf.api.v1;

public interface IMachinePort {
	
	/**
	 * Callback for when the attached machine's available outputs change
	 */
	public void onOutputsUpdated();

}

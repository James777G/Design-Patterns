package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface DealerAction {
	/**
	 * this function will decide what action (either hit or hold) the dealer will be
	 * taking
	 * 
	 * @param hand of the dealer
	 * @return type class action that will describe the action of the dealer
	 */
	public abstract Action actDealer(Hand hand);

}

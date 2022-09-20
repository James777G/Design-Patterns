package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;

/**
 * 
 * You should change this class for Task 2
 *
 */
public class Dealer extends Participant {

	// encapsulate the action
	private DealerAction dealerAction;

	/**
	 * this constructor will create a dealer class based on the two input parameters
	 * 
	 * @param name         of the dealer
	 * @param dealerAction that the dealer will take in respond to players
	 */
	public Dealer(String name, DealerAction dealerAction) {
		super(name);
		this.dealerAction = dealerAction;
	}

	/**
	 * this function will be helping dealer to make decisions (either hit or hold)
	 * based on hand
	 */
	@Override
	public Action decideAction(Hand hand) {
		return dealerAction.actDealer(hand);
	}

	/**
	 * this function will be setting up dealer action as a field to this class
	 * instance
	 * 
	 * @param dealerAction that the dealer will be taking to respond players
	 */
	public void setDealerAction(DealerAction dealerAction) {
		this.dealerAction = dealerAction;
	}

}

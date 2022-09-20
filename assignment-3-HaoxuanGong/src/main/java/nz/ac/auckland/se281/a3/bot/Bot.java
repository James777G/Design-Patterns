package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */
public class Bot extends Player {

	// encapsulate bot action and this action will only be set once each game
	private final BotAction botAction;

	/**
	 * this constructor will create an instance of robot based on the two input
	 * variables
	 * 
	 * @param name      name of the robot
	 * @param botAction Action class that the robot will be taking
	 */
	public Bot(String name, BotAction botAction) {
		super(name);
		this.botAction = botAction;
	}

	/**
	 * this function will decide which action robots will take to perform hit or
	 * hold
	 */
	@Override
	public Action decideAction(Hand hand) {
		Action action = this.botAction.decideBotAction(hand);
		return action;
	}

	/**
	 * this function will be making a bet for the robot based on different action
	 * pattern.
	 */
	@Override
	public int makeABet() {
		return this.botAction.betBot();
	}

}

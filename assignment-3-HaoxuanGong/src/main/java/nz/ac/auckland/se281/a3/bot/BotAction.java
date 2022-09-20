package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotAction {
	/**
	 * this function will return action (either hold or hit) based on the hands of
	 * the robot
	 * 
	 * @param hand hand of the robot
	 * @return the class action
	 */
	public abstract Action decideBotAction(Hand hand);

	/**
	 * the function will be helping the robots to make a bet based on different
	 * actions
	 * 
	 * @return an integer indicating number of bets the robot will put in.
	 */
	public abstract int betBot();

}

package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class HighRiskAction implements BotAction {

	/**
	 * this function will implement the high risk action behavior in deciding robot
	 * action (either hit or hold)
	 */
	@Override
	public Action decideBotAction(Hand hand) {
		if (hand.getScore() >= 19) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}

	}

	/**
	 * this function will implement the high risk action in making a bet for a
	 * robot.
	 */
	@Override
	public int betBot() {
		Random random = new Random();
		int a = random.nextInt(50, 101);
		return a;

	}

}

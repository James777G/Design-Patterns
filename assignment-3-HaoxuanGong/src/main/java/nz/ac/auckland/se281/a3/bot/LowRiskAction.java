package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class LowRiskAction implements BotAction {
	/**
	 * this function will implement the low risk action in making decisions (either
	 * hit or hold) for a robot
	 */
	@Override
	public Action decideBotAction(Hand hand) {
		if (hand.getScore() >= 17) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}

	}

	/**
	 * this function will be implementing the low risk action in making a bet for a
	 * robot
	 */
	@Override
	public int betBot() {
		Random random = new Random();
		int a = random.nextInt(10, 51);
		return a;

	}

}

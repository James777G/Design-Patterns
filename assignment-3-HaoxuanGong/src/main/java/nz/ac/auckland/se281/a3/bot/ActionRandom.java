package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class ActionRandom implements BotAction {
	/**
	 * this function implement the random action (either hit or hold) in making a
	 * decision for a robot
	 */
	@Override
	public Action decideBotAction(Hand hand) {
		Random random = new Random();
		Boolean a = random.nextBoolean();
		// if the bots get 21 then they will not hit again
		if (a || hand.is21()) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

	/**
	 * this function will be implementing the random action in making a bet for a
	 * robot
	 */
	@Override
	public int betBot() {
		Random random = new Random();
		int a = random.nextInt(100) + 1;
		return a;
	}

}

package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class TopWinnerAction implements DealerAction {
	private List<Player> players;

	/**
	 * this is the constructor for the class TopWinnerAction based on the same list
	 * from Black Jack player list
	 * 
	 * @param players will be same players list from BlackJack class
	 */
	public TopWinnerAction(List<Player> players) {
		this.players = players;
	}

	/**
	 * this function will be setting up dealer action in choosing the top winner as
	 * the opponent
	 */
	@Override
	public Action actDealer(Hand hand) {

		boolean isThereBlackJack = false;
		boolean haveBlackJack = false;
		// whether dealer has blackjack or not
		// whether the targeted player is already busted
		Action result = null;

		int handScore;
		// score of the players
		int deckNumber;
		int max = -999;
		// highest number of net wins among the players
		int number = 0;
		// the index of the player with highest net wins

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getNetWin() > max) {
				max = players.get(i).getNetWin();
				number = i;
			}
		}

		handScore = players.get(number).getHand().getScore();
		deckNumber = players.get(number).getHand().getCards().size();

		if (deckNumber == 2 && handScore == 21) {
			isThereBlackJack = true;
		}

		if (hand.getCards().size() == 2 && hand.getScore() == 21) {
			haveBlackJack = true;
		}

		// if player is not already busted
		if (players.get(number).getHand().isBust() == false) {
			// if player does not have black jack
			if (isThereBlackJack == false) {
				// hit or hold depends on score they have
				if (handScore > hand.getScore()) {
					result = Action.HIT;
				} else {
					result = Action.HOLD;
				}
			}
			if (isThereBlackJack) {
				// if player and dealer both have blackjack
				if (haveBlackJack) {
					result = Action.HOLD;
				} else {
					// if player has blackjack and dealer doesn't
					if (hand.getScore() >= 17) {
						result = Action.HOLD;
					} else {
						result = Action.HIT;
					}
				}
			}
		}
		// if the player is already busted then hold
		else {
			result = Action.HOLD;
		}

		return result;

	}

}

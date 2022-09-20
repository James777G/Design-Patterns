package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class BidderRichestAction implements DealerAction {
	private List<Player> players;

	/**
	 * this is the constructor for class HighestBidderAction taking the same list of
	 * Black Jack player lists
	 * 
	 * @param players will be the same as the players from BlackJack class
	 */
	public BidderRichestAction(List<Player> players) {
		this.players = players;
	}

	/**
	 * this function will be setting up dealer action in choosing highest bidder as
	 * the opponent
	 */
	@Override
	public Action actDealer(Hand hand) {
		int highestBet = 0;
		int number = 0;
		// number to trace which player is our target.
		int handScore;
		int deckNumber;
		boolean isThereBlackJack = false;
		boolean haveBlackJack = false;
		// whether dealer has blackjack or not
		Action result = null;

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getBet() > highestBet) {
				highestBet = players.get(i).getBet();
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
		if (!players.get(number).getHand().isBust()) {
			// if player does not have black jack
			if (!isThereBlackJack) {
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

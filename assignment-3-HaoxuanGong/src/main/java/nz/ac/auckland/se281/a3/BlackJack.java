package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.ActionFactory;
import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.bot.BotAction;
import nz.ac.auckland.se281.a3.dealer.BidderRichestAction;
import nz.ac.auckland.se281.a3.dealer.Dealer;
import nz.ac.auckland.se281.a3.dealer.DealerAction;
import nz.ac.auckland.se281.a3.dealer.TopWinnerAction;

/**
 * Unless it is specified in the JavaDoc, you cannot change any methods.
 * 
 * You can add new methods and/or new instance fields
 */
public class BlackJack {

	private List<Player> players;
	private Dealer dealer;
	private Deck deck;

	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
	}

	/**
	 * This constructor is for testing reasons
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	/**
	 * this constructor will create an instance of BlackJack based on the list of
	 * players
	 * 
	 * @param players2 are the list of players that will be joining the game
	 */
	public BlackJack(List<Player> players2) {
		// TODO Auto-generated constructor stub
	}

	public List<Player> getPlayers() {
		return players;
	}

	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	/**
	 * this method initiate the behaviors of robots with implemented different
	 * robots actions.
	 */
	protected void initBots() {

		String botStrategyString = getBotStrategy();
		// ActionFactory to create desired action
		BotAction botAction = ActionFactory.createBotAction(botStrategyString);
		Bot bot1 = new Bot("Bot1", botAction);
		Bot bot2 = new Bot("Bot2", botAction);
		// create and set Bots strategy here
		players.add(bot1);
		players.add(bot2);
	}

	/**
	 * this method initiate the behavior of dealers with implemented different
	 * dealers actions.
	 */
	protected void initDealer() {
		// set the initial strategy using the Strategy pattern

		DealerAction dealerAction = new BidderRichestAction(this.players);
		// only set the initial dealer strategy and will be updated after each round

		dealer = new Dealer("Dealer", dealerAction);
	}

	/**
	 * this method will keep track of number of wins and losses after each round and
	 * update it the results will also be printed in specific forms
	 * 
	 * @param round refers to the number of round of game
	 */
	protected void printAndUpdateResults(int round) {
		boolean busted = dealer.getHand().isBust();
		// if dealer is busted
		int dealerScore = dealer.getHand().getScore();
		// dealer's score
		int maxNetWin = 0;
		// highest number of net wins

		for (int i = 0; i < players.size(); i++) {
			// if the player is busted, then the player loses no matter what
			if (players.get(i).getHand().isBust()) {
				players.get(i).lose();
			}
			// if player has black jack and dealer does not then players win
			else if (players.get(i).getHand().isBlackJack() && dealer.getHand().isBlackJack() == false) {
				players.get(i).win();
			}
			// if player is not busted and dealer is busted then win
			else if (players.get(i).getHand().isBust() == false && busted) {
				players.get(i).win();
			}
			// if player is not busted and has a higher score than the dealer then win
			else if (players.get(i).getHand().getScore() > dealerScore && players.get(i).getHand().isBust() == false) {
				players.get(i).win();
			} else {
				players.get(i).lose();
			}

		}
		// find the highest number of net Wins
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getNetWin() > maxNetWin) {
				maxNetWin = players.get(i).getNetWin();
			}
		}

		// update the dealer strategy if net wins >= 2
		if (maxNetWin >= 2) {
			dealer.setDealerAction(new TopWinnerAction(this.players));
		} else {
			dealer.setDealerAction(new BidderRichestAction(this.players));
		}

		for (int i = 0; i < players.size(); i++) {
			System.out.println("Round " + round + ": " + players.get(i).getName() + " " + players.get(i).getWinOrLose()
					+ " " + players.get(i).getHand().getBet() + " " + "chips");
		}

	}

	/**
	 * print the final statistics of the game in certain forms at the end to give
	 * out messages to the user.
	 */
	protected void printGameStatistics() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + " won " + players.get(i).getNumberOfWons()
					+ " times and lost " + players.get(i).getNumberOfLoss() + " times");
		}

	}

}

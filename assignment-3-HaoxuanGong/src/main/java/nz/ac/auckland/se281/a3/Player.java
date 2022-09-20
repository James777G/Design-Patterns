package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {
	private int bet;
	private int score;
	private int netWin = 0;
	// whether the player won or lost the last game
	private String winOrLose;
	private int numberOfWons = 0;
	private int numberOfLoss = 0;

	public Player(String name) {
		super(name);
	}

	/**
	 * this function will be setting up the values of bet and stored as a field.
	 * 
	 * @param hand refers to the hand of the player
	 */
	public void setBet(Hand hand) {
		this.bet = hand.getBet();
	}

	/**
	 * this function will get the value of bet from the instance.
	 * 
	 * @return bet value stored as a integer field
	 */
	public int getBet() {
		return this.bet;
	}

	public abstract int makeABet();

	/**
	 * this function will get the value stored as score from the created instance
	 * 
	 * @return score stored as a integer field
	 */
	public int getScore() {
		return score;
	}

	/**
	 * this function will be setting up the values of score as an instance field
	 * 
	 * @param hand refers to the hand of the player
	 */
	public void setScore(Hand hand) {
		this.score = hand.getScore();
	}

	/**
	 * this function will be getting the number of net wins from the instance
	 * created.
	 * 
	 * @return netWin stored as a integer field
	 */
	public int getNetWin() {
		return netWin;
	}

	/**
	 * this function will be setting up the number of net wins and stored as
	 * instance field.
	 * 
	 * @param netWin is the number of net wins you want to set up for the player
	 */
	public void setNetWin(int netWin) {
		this.netWin = netWin;
	}

	/**
	 * execute when the player loses a round to keep track of number of losses
	 */
	public void lose() {
		this.netWin = this.netWin - 1;
		// update whether the player wins or lost the last game and record number of
		// loses
		this.setWinOrLose("lost");
		this.setNumberOfLoss(this.getNumberOfLoss() + 1);
	}

	/**
	 * execute when a player wins a round to keep track of number of wins
	 */
	public void win() {
		this.netWin = this.netWin + 1;
		// update whether the player wins or lost the last game and record number of
		// wins
		this.setWinOrLose("won");
		this.setNumberOfWons(this.getNumberOfWons() + 1);
	}

	/**
	 * this function will be getting the string win or lose and stored as a field
	 * 
	 * @return winOrLose stored as a field
	 */
	public String getWinOrLose() {
		return winOrLose;
	}

	/**
	 * this function will be setting up for whether its a win or lose in string
	 * 
	 * @param winOrLose string of whether its a win or lose
	 */
	public void setWinOrLose(String winOrLose) {
		this.winOrLose = winOrLose;
	}

	/**
	 * this function will be getting the number of won in total of the player
	 * instance
	 * 
	 * @return number of won stored as a field
	 */
	public int getNumberOfWons() {
		return numberOfWons;
	}

	/**
	 * this function will be setting up the number of Won in total of the player
	 * instance.
	 * 
	 * @param numberOfWons number of won you want to set up for this field
	 */
	public void setNumberOfWons(int numberOfWons) {
		this.numberOfWons = numberOfWons;
	}

	/**
	 * this function will be getting the number of losses in total of a player
	 * instance
	 * 
	 * @return number of loss stored as a field
	 */
	public int getNumberOfLoss() {
		return numberOfLoss;
	}

	/**
	 * this function will be setting up the total number of loss for a player
	 * instance.
	 * 
	 * @param numberOfLoss number that you want to set for number of losses as a
	 *                     field
	 */
	public void setNumberOfLoss(int numberOfLoss) {
		this.numberOfLoss = numberOfLoss;
	}

}

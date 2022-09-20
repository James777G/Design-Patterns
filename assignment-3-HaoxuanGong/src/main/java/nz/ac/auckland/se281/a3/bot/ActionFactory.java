package nz.ac.auckland.se281.a3.bot;

public class ActionFactory {
	/**
	 * static function used to create certain classes based on different conditions
	 * to create different action behaviors
	 * 
	 * @param type the user will type in this string and will be identified
	 * @return different classes all implementing BotAction
	 */
	public static BotAction createBotAction(String type) {
		// return different instances of different classes based on user's input
		switch (type) {
		case "R":
			return new ActionRandom();

		case "LR":
			return new LowRiskAction();

		case "HR":
			return new HighRiskAction();

		default:
			System.err.println("wrong action type");
			System.exit(0);
		}

		return null;
	}

}

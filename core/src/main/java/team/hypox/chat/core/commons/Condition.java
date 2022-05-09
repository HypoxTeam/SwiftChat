package team.hypox.chat.core.commons;

public class Condition {

	public static void expects(boolean expected, String exceptionMessage, String... var) {
		if (!expected) {
			throw new IllegalStateException(String.format(exceptionMessage, var));
		}
	}

}

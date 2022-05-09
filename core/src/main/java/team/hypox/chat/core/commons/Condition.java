package team.hypox.chat.core.commons;

public class Condition {

	public static void expects(boolean expected, String exceptionMessage) {
		if (!expected) {
			throw new IllegalStateException(exceptionMessage);
		}
	}

}

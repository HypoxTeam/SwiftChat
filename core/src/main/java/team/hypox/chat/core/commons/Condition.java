package team.hypox.chat.core.commons;

public class Condition {

	/**
	 * Assert if the expected value is true, if not throw a exception
	 * @param expected The expected value
	 * @param exceptionMessage The exception message
	 * @param var vars...
	 */
	public static void expects(boolean expected, String exceptionMessage, Object... var) {
		if (!expected) {
			throw new IllegalStateException(String.format(exceptionMessage, var));
		}
	}

}

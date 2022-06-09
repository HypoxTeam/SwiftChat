package team.hypox.chat.core.commons;

public class Condition {

	public static void expects(boolean expected, String exceptionMessage, Object... var) {
		if (!expected) {
			throw new IllegalStateException(String.format(exceptionMessage, var));
		}
	}

	public static <T> void needNull(T nullable, String exceptionMessage, Object... vars) {
		expects(nullable == null, exceptionMessage, vars);
	}

	public static <T> T notNull(T nullable, String exceptionMessage, Object... var) {
		expects(nullable != null, exceptionMessage, var);

		return nullable;
	}

	public static <T> boolean isNull(T nullable) {
		return nullable == null;
	}

}

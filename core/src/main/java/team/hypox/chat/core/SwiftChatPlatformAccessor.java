package team.hypox.chat.core;

import team.hypox.chat.core.commons.Condition;

public class SwiftChatPlatformAccessor {

	private static SwiftChatPlatform platform;

	/**
	 * Get access to the current SwiftChatPlatform implementation
	 * the method throws an IllegalArgumentException if is not a Platform with granted access yet
	 * @return SwiftChatPlatform implementation
	 */
	public static synchronized SwiftChatPlatform access() {
		Condition.notNull(
				platform,
				"SwiftChat platform implementation is not accessible yet"
		);

		return platform;
	}

	/**
	 * Grant access to the SwiftChatPlatformAccessor singleton
	 * only the platform will be placed if is not already granted access
	 * @param accessPlatform SwiftChatPlatform implementation
	 */
	public static synchronized void grantAccess(SwiftChatPlatform accessPlatform) {
		if (platform == null) {
			platform = accessPlatform;
		}
	}

}

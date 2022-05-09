package team.hypox.chat.core;

import team.hypox.chat.core.commons.Condition;

public class SwiftChatPlatformAccessor {

	private static SwiftChatPlatform platform;

	public static synchronized SwiftChatPlatform access() {
		Condition.expects(
				platform != null,
				"SwiftChat platform implementation is not accessible yet"
		);

		return platform;
	}

	public static synchronized void grantAccess(SwiftChatPlatform accessPlatform) {
		if (platform == null) {
			platform = accessPlatform;
		}
	}

}

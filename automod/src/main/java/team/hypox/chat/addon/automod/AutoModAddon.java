package team.hypox.chat.addon.automod;

import team.hypox.chat.addon.automod.toxicity.ToxicityCondition;
import team.hypox.chat.core.SwiftChatPlatform;
import team.hypox.chat.core.SwiftChatPlatformAccessor;

public class AutoModAddon {

	public void initialize() {
		SwiftChatPlatform platform = SwiftChatPlatformAccessor.access();
		AutoModService modService = new AutoModService(platform.configurationFactory());

		platform.decoratorNamespace()
				.use(ToxicityCondition.class, ToxicityCondition.withoutDecorator(modService));
	}

}

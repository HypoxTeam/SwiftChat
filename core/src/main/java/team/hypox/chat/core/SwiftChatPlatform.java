package team.hypox.chat.core;

import team.hypox.chat.core.channel.ChannelContainer;
import team.hypox.chat.core.configuration.ConfigurationFactory;
import team.hypox.chat.core.extend.DecoratorNamespace;

public abstract class SwiftChatPlatform {

	public void enable() {
		try {
			setup();
		} finally {
			SwiftChatPlatformAccessor.grantAccess(this);
		}
	}

	protected abstract void setup();

	protected ChannelContainer channelContainer;
	protected ConfigurationFactory configurationFactory;
	protected DecoratorNamespace decoratorNamespace;

	public DecoratorNamespace decoratorNamespace() {
		return decoratorNamespace;
	}

	public ConfigurationFactory configurationFactory() {
		return configurationFactory;
	}

	public ChannelContainer channelContainer() {
		return channelContainer;
	}
}

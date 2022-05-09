package team.hypox.chat.core;

import team.hypox.chat.core.channel.ChannelContainer;
import team.hypox.chat.core.configuration.ConfigurationFactory;

public abstract class SwiftChatPlatform {

	protected abstract void setup();

	protected ChannelContainer channelContainer;
	protected ConfigurationFactory configurationFactory;

	public ConfigurationFactory getConfigurationFactory() {
		return configurationFactory;
	}

	public ChannelContainer getChannelContainer() {
		return channelContainer;
	}
}

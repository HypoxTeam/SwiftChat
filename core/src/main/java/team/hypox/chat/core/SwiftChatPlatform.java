package team.hypox.chat.core;

import team.hypox.chat.core.channel.ChannelContainer;
import team.hypox.chat.core.channel.ChannelFactory;
import team.hypox.chat.core.commons.Condition;
import team.hypox.chat.core.configuration.ConfigurationFactory;
import team.hypox.chat.core.extend.AudienceArgumentProcessor;
import team.hypox.chat.core.extend.AudienceNamespace;
import team.hypox.chat.core.extend.DecoratorNamespace;

public abstract class SwiftChatPlatform {

	private boolean enabled = false;

	public void enable() {
		Condition.expects(!enabled, "SwiftChat is already enabled");

		try {
			setup();
		} finally {
			enabled = true;
			SwiftChatPlatformAccessor.grantAccess(this);
		}
	}

	protected abstract void setup();

	protected ChannelContainer channelContainer;
	protected ConfigurationFactory configurationFactory;
	protected DecoratorNamespace decoratorNamespace;
	protected AudienceArgumentProcessor argumentProcessor;
	protected AudienceNamespace audienceNamespace;
	protected ChannelFactory channelFactory;

	public ChannelFactory channelFactory() {
		return channelFactory;
	}

	public AudienceNamespace audienceNamespace() {
		return audienceNamespace;
	}

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

package team.hypox.chat.core;

import team.hypox.chat.core.channel.ChannelContainer;
import team.hypox.chat.core.channel.ChannelFactory;
import team.hypox.chat.core.commons.Condition;
import team.hypox.chat.core.configuration.ConfigurationFactory;
import team.hypox.chat.core.extend.AudienceArgumentProcessor;
import team.hypox.chat.core.extend.AudienceNamespace;
import team.hypox.chat.core.extend.DecoratorNamespace;
import team.hypox.chat.core.structure.member.cache.MemberCache;

public abstract class SwiftChatPlatform {

	private boolean enabled = false;

	/**
	 * Enable SwiftChat.
	 * SwiftChatPlatformAccessor will be granted access if is not already linked with other Platform
	 * this method throws an IllegalArgumentException if the Platform is already enabled!
	 */
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

	protected MemberCache memberCache;
	protected ChannelContainer channelContainer;
	protected ConfigurationFactory configurationFactory;
	protected DecoratorNamespace decoratorNamespace;
	protected AudienceArgumentProcessor argumentProcessor;
	protected AudienceNamespace audienceNamespace;
	protected ChannelFactory channelFactory;

	public MemberCache memberCache() {
		return memberCache;
	}

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

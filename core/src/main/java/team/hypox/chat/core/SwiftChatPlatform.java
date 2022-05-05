package team.hypox.chat.core;

import team.hypox.chat.core.channel.ChannelContainer;

public abstract class SwiftChatPlatform {

	public abstract void setup();

	protected ChannelContainer channelContainer;

	public ChannelContainer getChannelContainer() {
		return channelContainer;
	}
}

package team.hypox.chat.spigot.platform;

import team.hypox.chat.core.channel.ChannelContainer;
import team.hypox.chat.core.driver.ChannelDriver;
import team.hypox.chat.core.structure.channel.Channel;

public class ChannelCacheContainer implements ChannelContainer {

	@Override
	public ChannelContainer loadFromDriver(ChannelDriver driver) {
		return null;
	}

	@Override
	public ChannelContainer register(String channelName, Channel channel) {

		return this;
	}

	@Override
	public Channel search(String channelName) {
		return null;
	}

	@Override
	public Channel searchOrDefault(String channelName) {
		return null;
	}

	@Override
	public Channel defaultChannel() {
		return null;
	}
}

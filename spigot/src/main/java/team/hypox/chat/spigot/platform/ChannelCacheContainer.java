package team.hypox.chat.spigot.platform;

import team.hypox.chat.core.channel.ChannelContainer;
import team.hypox.chat.core.structure.channel.Channel;

public class ChannelCacheContainer implements ChannelContainer {
	@Override
	public ChannelContainer loadFromDriver() {
		return null;
	}

	@Override
	public void register(String channelName, Channel channel) {

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

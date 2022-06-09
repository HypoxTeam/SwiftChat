package team.hypox.chat.spigot.platform;

import team.hypox.chat.core.channel.ChannelContainer;
import team.hypox.chat.core.driver.ChannelDriver;
import team.hypox.chat.core.structure.channel.Channel;

import java.util.HashMap;
import java.util.Map;

public class ChannelCacheContainer implements ChannelContainer {

	private final Map<String, Channel> container = new HashMap<>();
	private final Channel defaultChannel;

	public ChannelCacheContainer(Channel defaultChannel) {
		this.defaultChannel = defaultChannel;
	}

	@Override
	public ChannelContainer loadFromDriver(ChannelDriver driver) {
		driver.asyncIterator()
				.thenAccept(
						channelIterator -> channelIterator.forEachRemaining(this::register)
				);

		return this;
	}

	@Override
	public ChannelContainer register(String channelName, Channel channel) {
		container.put(channelName, channel);
		return this;
	}

	@Override
	public Channel search(String channelName) {
		return container.get(channelName);
	}

	@Override
	public Channel searchOrDefault(String channelName) {
		return container.getOrDefault(channelName, defaultChannel());
	}

	@Override
	public Channel defaultChannel() {
		return defaultChannel;
	}
}

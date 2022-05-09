package team.hypox.chat.core.channel;

import team.hypox.chat.core.driver.ChannelDriver;
import team.hypox.chat.core.structure.channel.Channel;

public interface ChannelContainer {

	ChannelContainer loadFromDriver(ChannelDriver driver);

	default ChannelContainer register(Channel channel) {
		return register(channel.data().getName(), channel);
	}

	ChannelContainer register(String channelName, Channel channel);

	Channel search(String channelName);

	Channel searchOrDefault(String channelName);

	Channel defaultChannel();

}

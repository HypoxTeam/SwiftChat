package team.hypox.chat.core.channel;

import team.hypox.chat.core.structure.channel.Channel;

public interface ChannelContainer {

	ChannelContainer loadFromDriver();

	void register(String channelName, Channel channel);

	Channel search(String channelName);

	Channel searchOrDefault(String channelName);

	Channel defaultChannel();

}

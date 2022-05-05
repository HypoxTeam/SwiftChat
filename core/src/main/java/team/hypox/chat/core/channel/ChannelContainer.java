package team.hypox.chat.core.channel;

import com.sun.istack.internal.Nullable;
import team.hypox.chat.core.structure.channel.Channel;

public interface ChannelContainer {

	ChannelContainer loadFromDriver();

	void register(String channelName, Channel channel);

	@Nullable Channel search(String channelName);

	Channel searchOrDefault(String channelName);

	Channel defaultChannel();

}

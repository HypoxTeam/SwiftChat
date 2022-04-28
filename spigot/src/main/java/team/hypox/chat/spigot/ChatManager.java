package team.hypox.chat.spigot;

import team.hypox.chat.core.channel.Channel;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.spigot.message.SimpleMessageContext;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ChatManager {

	private final Map<String, Channel> channels = new HashMap<>();
	private final Map<ChannelMember, Channel> activeChannels = new HashMap<>();
	private final Map<UUID, ChannelMember> members = new HashMap<>();

	public ChannelMember from(UUID id) {
		return members.get(id);
	}

	public Channel activeChannel(ChannelMember channelMember) {
		return activeChannels.get(channelMember);
	}

	public void sendMessage(Channel channel, ChannelMember channelMember, String message) {
		channel.notifyMessage(SimpleMessageContext.create(channelMember, message));
	}

}

package team.hypox.chat.core.member;

import team.hypox.chat.core.message.MessageContext;

import java.util.UUID;

public interface ChannelMember {

	String name();

	UUID id();

	void sendMessage(MessageContext message);

}

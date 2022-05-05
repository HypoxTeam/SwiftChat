package team.hypox.chat.core.structure.member;

import team.hypox.chat.core.structure.message.MessageContext;

import java.util.UUID;

public interface ChannelMember {

	String name();

	UUID id();

	void sendMessage(MessageContext message);

}

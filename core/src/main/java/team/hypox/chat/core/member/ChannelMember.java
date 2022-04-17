package team.hypox.chat.core.member;

import team.hypox.chat.core.message.MessageContext;

import java.util.UUID;

public interface ChannelMember {

	UUID id();

	ChannelMemberPreferences preferences();

	void sendMessage(MessageContext message);

}

package team.hypox.chat.core.structure.message;

import team.hypox.chat.core.structure.member.ChannelMember;

public interface MessageContext {

	String message();

	ChannelMember author();

	void formatMessage(String newFormattedMessage);

	String formattedMessage();

	MessageContext clone();

}

package team.hypox.chat.core.message;

import team.hypox.chat.core.member.ChannelMember;

public interface MessageContext {

	String message();

	ChannelMember author();

	void formatMessage(String newFormattedMessage);

	String formattedMessage();

	MessageContext clone();

}

package team.hypox.chat.core.channel;

import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;

public interface ChannelFormatter {

	/**
	 * Format message per recipient, only use this method if you want to customize a format per recipient
	 * for example for colorize mentions to a specific recipient, underline bad words per member etc...
	 * if you want to format message globally (for all recipients) use the other method
	 * @param ctx Message context
	 * @param recipient Recipient to format context
	 * @return new message context formatted
	 */
	MessageContext formatMessage(MessageContext ctx, ChannelMember recipient);

	/**
	 * Format message globally, all recipients will be format the message, if you want to customize per recipient
	 * use the other method
	 * @param ctx Message context
	 * @return new message context formatted
	 */
	MessageContext formatMessage(MessageContext ctx);

}

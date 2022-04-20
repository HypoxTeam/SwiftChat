package team.hypox.chat.core.channel;

import team.hypox.chat.core.message.MessageContext;

public interface Channel {

	/**
	 * Notify all ChannelMember audiences for a new message
	 * @param ctx Message context
	 */
	void notifyMessage(MessageContext ctx);

}

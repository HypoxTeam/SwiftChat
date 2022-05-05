package team.hypox.chat.core.structure.channel;

import team.hypox.chat.core.structure.message.MessageContext;

public interface Channel {

	/**
	 * Notify all ChannelMember audiences for a new message
	 * @param ctx Message context
	 */
	void notifyMessage(MessageContext ctx);

}

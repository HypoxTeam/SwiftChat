package team.hypox.chat.core.structure.channel;

import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.structure.message.MessageContext;

public interface Channel {

	ChannelData data();

	/**
	 * Notify all ChannelMember audiences for a new message
	 * @param ctx Message context
	 */
	void notifyMessage(MessageContext ctx);

}

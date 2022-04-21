package team.hypox.chat.core.channel;

import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;

public interface ChannelCondition {

	/**
	 * A channel condition for receive the message.
	 * Example use case:
	 * - ignore an author
	 * @param recipient to predicate if can listen
	 * @param ctx Message context
	 * @return true if can listen otherwise false
	 */
	boolean canListen(ChannelMember recipient, MessageContext ctx);

}

package team.hypox.chat.core.structure.channel;

import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

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

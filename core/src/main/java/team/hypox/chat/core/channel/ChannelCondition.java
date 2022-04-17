package team.hypox.chat.core.channel;

import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;

public interface ChannelCondition {

	boolean canListen(ChannelMember member, MessageContext ctx);

}

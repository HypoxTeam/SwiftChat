package team.hypox.chat.channel;

import team.hypox.chat.member.ChannelMember;
import team.hypox.chat.message.MessageContext;

public interface ChannelCondition {

	boolean canListen(ChannelMember member, MessageContext ctx);

}

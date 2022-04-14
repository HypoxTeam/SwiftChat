package team.hypox.chat.channel.decorator;

import lombok.Data;
import team.hypox.chat.channel.ChannelCondition;
import team.hypox.chat.member.ChannelMember;
import team.hypox.chat.message.MessageContext;

@Data
public abstract class DecoratorChannelCondition implements ChannelCondition {

	private final ChannelCondition condition;

	@Override
	public boolean canListen(ChannelMember member, MessageContext ctx) {
		return condition.canListen(member, ctx);
	}
}

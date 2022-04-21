package team.hypox.chat.core.channel.decorator;

import lombok.Data;
import team.hypox.chat.core.channel.ChannelCondition;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;

@Data
public abstract class DecoratorChannelCondition implements ChannelCondition {

	private final ChannelCondition condition;

	@Override
	public boolean canListen(ChannelMember recipient, MessageContext ctx) {
		return condition.canListen(recipient, ctx);
	}

	public static class EndDecorator implements ChannelCondition {

		@Override
		public boolean canListen(ChannelMember recipient, MessageContext ctx) {
			return true;
		}
	}

}

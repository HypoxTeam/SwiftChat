package team.hypox.chat.core.structure.channel.decorator;

import lombok.Data;
import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

@Data
public abstract class DecoratorChannelCondition implements ChannelCondition {

	private final ChannelCondition condition;

	@Override
	public boolean canListen(ChannelMember recipient, MessageContext ctx, ChannelData channelData) {
		return condition.canListen(recipient, ctx, channelData);
	}

	public static class EndDecorator implements ChannelCondition {

		@Override
		public boolean canListen(ChannelMember recipient, MessageContext ctx, ChannelData channelData) {
			return true;
		}
	}

}

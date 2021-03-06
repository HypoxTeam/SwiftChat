package team.hypox.chat.core.structure.channel.decorator;

import lombok.Data;
import team.hypox.chat.core.structure.channel.ChannelFormatter;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

@Data
public abstract class DecoratorChannelFormatter implements ChannelFormatter {

	private final ChannelFormatter formatter;

	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
		return formatter.formatMessage(ctx, recipient);
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx) {
		return formatter.formatMessage(ctx);
	}

	public static class EndDecorator implements ChannelFormatter {

		@Override
		public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
			return ctx;
		}

		@Override
		public MessageContext formatMessage(MessageContext ctx) {
			return ctx;
		}
	}
}

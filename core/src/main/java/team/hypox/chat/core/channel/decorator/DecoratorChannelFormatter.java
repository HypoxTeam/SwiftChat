package team.hypox.chat.core.channel.decorator;

import lombok.Data;
import team.hypox.chat.core.channel.ChannelFormatter;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;

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
}

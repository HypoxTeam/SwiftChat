package team.hypox.chat.spigot.format;

import team.hypox.chat.core.structure.channel.ChannelFormatter;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelFormatter;
import team.hypox.chat.core.structure.message.MessageContext;

public class DotChannelFormatter extends DecoratorChannelFormatter {
	public DotChannelFormatter(ChannelFormatter formatter) {
		super(formatter);
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx) {
		return addDot(super.formatMessage(ctx));
	}

	private MessageContext addDot(MessageContext ctx) {
		ctx.formatMessage(ctx.formattedMessage() + ".");
		return ctx;
	}
}

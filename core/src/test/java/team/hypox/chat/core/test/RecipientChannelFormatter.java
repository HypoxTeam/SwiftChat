package team.hypox.chat.core.test;

import team.hypox.chat.core.structure.channel.ChannelFormatter;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelFormatter;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

public class RecipientChannelFormatter extends DecoratorChannelFormatter {
	public RecipientChannelFormatter(ChannelFormatter formatter) {
		super(formatter);
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
		return format(super.formatMessage(ctx, recipient), recipient);
	}

	private MessageContext format(MessageContext ctx, ChannelMember recipient) {
		ctx.formatMessage(ctx.formattedMessage() + "| sent for: " + recipient.name());

		return ctx;
	}
}

package team.hypox.chat.core.test;

import team.hypox.chat.core.channel.ChannelFormatter;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;

public class EndFormat implements ChannelFormatter {
	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
		return ctx;
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx) {
		return ctx;
	}
}

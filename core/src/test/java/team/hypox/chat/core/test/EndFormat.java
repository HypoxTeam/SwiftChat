package team.hypox.chat.core.test;

import team.hypox.chat.core.structure.channel.ChannelFormatter;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

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

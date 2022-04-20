package team.hypox.chat.core.test;

import team.hypox.chat.core.channel.AbstractChannel;
import team.hypox.chat.core.channel.ChannelFormatter;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;
import team.hypox.chat.core.util.ChannelMemberList;

public class TestGlobalChannel extends AbstractChannel {

	private final ChannelFormatter formatter = new MentionChannelFormatter(new RecipientChannelFormatter(new EndFormat()));

	@Override
	public boolean canListen(ChannelMember member, MessageContext ctx) {
		return true;
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx) {
		ctx.formatMessage(ctx.author().name() + " -> " + ctx.message());
		return ctx;
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
		return formatter.formatMessage(ctx, recipient);
	}

	@Override
	protected ChannelMemberList audience() {
		return ChannelTest.MEMBERS;
	}

}

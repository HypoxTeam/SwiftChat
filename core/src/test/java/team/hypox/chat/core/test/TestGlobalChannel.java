package team.hypox.chat.core.test;

import team.hypox.chat.core.structure.channel.AbstractChannel;
import team.hypox.chat.core.structure.channel.ChannelFormatter;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;
import team.hypox.chat.core.util.ChannelMemberList;

public class TestGlobalChannel extends AbstractChannel {

	private final ChannelFormatter formatter = new MentionChannelFormatter(new RecipientChannelFormatter(new EndFormat()));

	public TestGlobalChannel() {
		super(name);
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

package team.hypox.chat.core.channel;

import team.hypox.chat.core.structure.channel.AbstractChannel;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.ChannelFormatter;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;
import team.hypox.chat.core.util.AudienceProvider;
import team.hypox.chat.core.util.ChannelMemberList;

public class SampleChannel extends AbstractChannel {

	private final AudienceProvider audience;
	private final ChannelFormatter formatter;
	private final ChannelCondition condition;

	public SampleChannel(AudienceProvider audience, ChannelFormatter formatter, ChannelCondition condition) {
		this.audience = audience;
		this.formatter = formatter;
		this.condition = condition;
	}

	@Override
	public boolean canListen(ChannelMember recipient, MessageContext ctx) {
		return condition.canListen(recipient, ctx);
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx) {
		return formatter.formatMessage(ctx);
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
		return formatter.formatMessage(ctx, recipient);
	}

	@Override
	protected ChannelMemberList audience() {
		return audience.invoke();
	}

}

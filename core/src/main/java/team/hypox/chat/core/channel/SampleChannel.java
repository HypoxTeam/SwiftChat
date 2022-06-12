package team.hypox.chat.core.channel;

import team.hypox.chat.core.structure.channel.AbstractChannel;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.ChannelFormatter;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;
import team.hypox.chat.core.util.AudienceProvider;
import team.hypox.chat.core.util.ChannelMemberList;

import java.util.Collections;
import java.util.List;

public class SampleChannel extends AbstractChannel {

	private final AudienceProvider audience;
	private final List<ChannelFormatter> formatter;
	private final List<ChannelCondition> condition;

	public SampleChannel(ChannelData data, AudienceProvider audience, ChannelFormatter formatter, ChannelCondition condition) {
		this(data, audience, Collections.singletonList(formatter), Collections.singletonList(condition));
	}

	public SampleChannel(ChannelData data, AudienceProvider audience, List<ChannelFormatter> formatter, List<ChannelCondition> condition) {
		super(data);
		this.audience = audience;
		this.formatter = formatter;
		this.condition = condition;
	}

	@Override
	public boolean canListen(ChannelMember recipient, MessageContext ctx, ChannelData channelData) {
		for (ChannelCondition channelCondition : condition) {
			if (!channelCondition.canListen(recipient, ctx, channelData)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelData channelData) {
		for (ChannelFormatter channelFormatter : formatter) {
			ctx = channelFormatter.formatMessage(ctx, channelData);
		}

		return ctx;
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient, ChannelData channelData) {
		for (ChannelFormatter channelFormatter : formatter) {
			ctx = channelFormatter.formatMessage(ctx, recipient, channelData);
		}

		return ctx;
	}

	@Override
	protected ChannelMemberList audience() {
		return audience.invoke();
	}

}

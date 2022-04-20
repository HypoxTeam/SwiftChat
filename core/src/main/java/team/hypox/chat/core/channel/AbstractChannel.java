package team.hypox.chat.core.channel;

import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;
import team.hypox.chat.core.util.ChannelMemberList;

public abstract class AbstractChannel implements Channel, ChannelCondition, ChannelFormatter {

	@Override
	public void notifyMessage(MessageContext ctx) {
		ChannelMemberList audience = audience();

		for (ChannelMember member : audience) {
			if (canListen(member, ctx)) {
				member.sendMessage(formatMessage(ctx, member));
			}
		}
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
		return ctx;
	}

	@Override
	public abstract boolean canListen(ChannelMember member, MessageContext ctx);

	protected abstract ChannelMemberList audience();

}

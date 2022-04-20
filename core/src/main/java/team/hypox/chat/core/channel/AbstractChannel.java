package team.hypox.chat.core.channel;

import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;
import team.hypox.chat.core.util.ChannelMemberList;

public abstract class AbstractChannel implements Channel, ChannelCondition, ChannelFormatter {

	@Override
	public void notifyMessage(MessageContext ctx) {
		ChannelMemberList audience = audience();
		MessageContext formattedContext = formatMessage(ctx);

		for (ChannelMember member : audience) {
			if (canListen(member, formattedContext)) {
				member.sendMessage(formatMessage(formattedContext.clone(), member));
			}
		}
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
		return ctx;
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx) {
		return ctx;
	}

	@Override
	public boolean canListen(ChannelMember member, MessageContext ctx) {
		return true;
	}

	/**
	 * Provides a channel member list to notify the new message
	 * @return a new audience
	 */
	protected abstract ChannelMemberList audience();

}

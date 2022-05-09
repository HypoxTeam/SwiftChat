package team.hypox.chat.core.structure.channel;

import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;
import team.hypox.chat.core.util.ChannelMemberList;

public abstract class AbstractChannel implements Channel, ChannelCondition, ChannelFormatter {

	private final ChannelData data;

	protected AbstractChannel(ChannelData data) {
		this.data = data;
	}

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

	/**
	 * Provides a channel member list to notify the new message
	 * @return a new audience
	 */
	protected abstract ChannelMemberList audience();

	/*
		Implemented by default, override this methods if is necessary in child classes
	 */
	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
		return ctx;
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx) {
		return ctx;
	}

	@Override
	public boolean canListen(ChannelMember recipient, MessageContext ctx) {
		return true;
	}

	@Override
	public ChannelData data() {
		return data;
	}
}

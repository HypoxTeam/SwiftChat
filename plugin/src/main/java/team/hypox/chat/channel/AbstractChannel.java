package team.hypox.chat.channel;

import team.hypox.chat.member.ChannelMember;
import team.hypox.chat.message.MessageContext;
import team.hypox.chat.util.ChannelMemberList;

public abstract class AbstractChannel implements Channel, ChannelCondition {

	@Override
	public void notifyMessage(MessageContext ctx) {
		ChannelMemberList audience = audience();

		for (ChannelMember member : audience) {
			if (canListen(member, ctx)) {
				member.sendMessage(ctx.content());
			}
		}
	}

	@Override
	public abstract boolean canListen(ChannelMember member, MessageContext ctx);

	protected abstract ChannelMemberList audience();

}

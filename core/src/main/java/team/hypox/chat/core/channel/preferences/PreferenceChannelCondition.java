package team.hypox.chat.core.channel.preferences;

import team.hypox.chat.core.channel.ChannelCondition;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;

public class PreferenceChannelCondition implements ChannelCondition {

	@Override
	public boolean canListen(ChannelMember member, MessageContext ctx) {
		return !member.preferences().ignores(ctx.author());
	}
}

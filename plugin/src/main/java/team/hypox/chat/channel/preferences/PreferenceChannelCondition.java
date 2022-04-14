package team.hypox.chat.channel.preferences;

import team.hypox.chat.channel.ChannelCondition;
import team.hypox.chat.member.ChannelMember;
import team.hypox.chat.message.MessageContext;

public class PreferenceChannelCondition implements ChannelCondition {

	@Override
	public boolean canListen(ChannelMember member, MessageContext ctx) {
		return !member.preferences().ignores(ctx.author());
	}
}

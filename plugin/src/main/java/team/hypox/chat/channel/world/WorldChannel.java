package team.hypox.chat.channel.world;

import team.hypox.chat.bukkit.WorldWrapper;
import team.hypox.chat.channel.AbstractChannel;
import team.hypox.chat.channel.ChannelCondition;
import team.hypox.chat.channel.preferences.PreferenceChannelCondition;
import team.hypox.chat.member.ChannelMember;
import team.hypox.chat.message.MessageContext;
import team.hypox.chat.util.ChannelMemberList;

public class WorldChannel extends AbstractChannel {

	private final WorldWrapper worldReference;
	private final ChannelCondition condition;

	public WorldChannel(WorldWrapper worldReference) {
		this.worldReference = worldReference;
		this.condition = new WorldChannelCondition(worldReference, new PreferenceChannelCondition());
	}

	@Override
	public boolean canListen(ChannelMember member, MessageContext ctx) {
		return condition.canListen(member, ctx);
	}

	@Override
	protected ChannelMemberList audience() {
		return worldReference.audience();
	}
}

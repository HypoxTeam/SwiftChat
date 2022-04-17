package team.hypox.chat.spigot.channel.world;

import team.hypox.chat.core.channel.AbstractChannel;
import team.hypox.chat.core.channel.ChannelCondition;
import team.hypox.chat.core.channel.preferences.PreferenceChannelCondition;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;
import team.hypox.chat.core.util.ChannelMemberList;
import team.hypox.chat.spigot.bukkit.WorldWrapper;

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

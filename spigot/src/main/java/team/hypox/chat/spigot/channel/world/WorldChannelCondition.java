package team.hypox.chat.spigot.channel.world;

import team.hypox.chat.core.channel.ChannelCondition;
import team.hypox.chat.core.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;
import team.hypox.chat.spigot.bukkit.WorldWrapper;
import team.hypox.chat.spigot.member.SpigotChannelMember;

public class WorldChannelCondition extends DecoratorChannelCondition {

	private final WorldWrapper worldWrapper;

	public WorldChannelCondition(WorldWrapper worldWrapper, ChannelCondition decorators) {
		super(decorators);

		this.worldWrapper = worldWrapper;
	}

	@Override
	public boolean canListen(ChannelMember member, MessageContext ctx) {
		return super.canListen(member, ctx) && worldCanListen(member, ctx.author());
	}

	private boolean worldCanListen(ChannelMember member, ChannelMember author) {
		if (!(member instanceof SpigotChannelMember && author instanceof SpigotChannelMember)) {
			return false;
		}

		SpigotChannelMember playerMember = (SpigotChannelMember) member;

		return playerMember.bukkit().getWorld().getName()
				.equalsIgnoreCase(
						worldWrapper.getName()
				);
	}

}

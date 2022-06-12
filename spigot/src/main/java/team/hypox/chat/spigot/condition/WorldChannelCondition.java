package team.hypox.chat.spigot.condition;

import org.bukkit.World;
import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;
import team.hypox.chat.spigot.member.SpigotChannelMember;

public class WorldChannelCondition extends DecoratorChannelCondition {

	public static WorldChannelCondition withoutDecorates() {
		return new WorldChannelCondition(new EndDecorator());
	}

	public WorldChannelCondition(ChannelCondition decorators) {
		super(decorators);
	}

	@Override
	public boolean canListen(ChannelMember member, MessageContext ctx, ChannelData channelData) {
		return super.canListen(member, ctx, channelData) && worldCanListen(member, channelData);
	}

	private boolean worldCanListen(ChannelMember member, ChannelData channelData) {
		World world = channelData.options()
				.condition(WorldChannelCondition.class)
				.as(World.class);

		SpigotChannelMember playerMember = (SpigotChannelMember) member;

		return playerMember.bukkit().getWorld().getName()
				.equalsIgnoreCase(
						world.getName()
				);
	}

}

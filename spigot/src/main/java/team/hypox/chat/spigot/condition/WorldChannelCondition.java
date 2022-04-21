package team.hypox.chat.spigot.condition;

import org.bukkit.World;
import team.hypox.chat.core.channel.ChannelCondition;
import team.hypox.chat.core.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;
import team.hypox.chat.spigot.member.SpigotChannelMember;

public class WorldChannelCondition extends DecoratorChannelCondition {

	private final World world;

	public WorldChannelCondition(World world, ChannelCondition decorators) {
		super(decorators);
		this.world = world;
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
						world.getName()
				);
	}

}

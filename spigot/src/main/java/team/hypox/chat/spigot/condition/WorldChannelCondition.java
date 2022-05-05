package team.hypox.chat.spigot.condition;

import org.bukkit.World;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;
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

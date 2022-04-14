package team.hypox.chat.channel.world;

import team.hypox.chat.bukkit.WorldWrapper;
import team.hypox.chat.channel.ChannelCondition;
import team.hypox.chat.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.member.ChannelMember;
import team.hypox.chat.member.PlayerChannelMember;
import team.hypox.chat.message.MessageContext;

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
		if (!(member instanceof PlayerChannelMember && author instanceof PlayerChannelMember)) {
			return false;
		}

		PlayerChannelMember playerMember = (PlayerChannelMember) member;
		PlayerChannelMember playerAuthor = (PlayerChannelMember) author;

		return playerMember.bukkit().getWorld().getName()
				.equalsIgnoreCase(
						playerAuthor.bukkit().getWorld().getName()
				);
	}

}

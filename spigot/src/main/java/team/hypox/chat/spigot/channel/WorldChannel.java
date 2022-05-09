package team.hypox.chat.spigot.channel;

import org.bukkit.World;
import team.hypox.chat.core.structure.channel.AbstractChannel;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;
import team.hypox.chat.core.util.ChannelMemberList;
import team.hypox.chat.spigot.bukkit.AudienceFactory;
import team.hypox.chat.spigot.condition.WorldChannelCondition;

public class WorldChannel extends AbstractChannel {

	private final AudienceFactory audienceFactory;
	private final World world;

	private final ChannelCondition condition;

	public WorldChannel(AudienceFactory audienceFactory, World world) {
		this.audienceFactory = audienceFactory;
		this.world = world;
		this.condition = new WorldChannelCondition(world, new DecoratorChannelCondition.EndDecorator());
	}

	@Override
	public boolean canListen(ChannelMember member, MessageContext ctx) {
		return condition.canListen(member, ctx);
	}

	@Override
	protected ChannelMemberList audience() {
		return audienceFactory.world(world).invoke();
	}
}

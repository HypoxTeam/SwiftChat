package team.hypox.chat.spigot.condition;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

public class RadialChannelCondition extends DecoratorChannelCondition {

	public static RadialChannelCondition withoutDecorates() {
		return new RadialChannelCondition(new EndDecorator());
	}

	public RadialChannelCondition(ChannelCondition condition) {
		super(condition);
	}

	@Override
	public boolean canListen(ChannelMember recipient, MessageContext ctx, ChannelData channelData) {
		return super.canListen(recipient, ctx, channelData) && isInRadius(recipient, ctx, channelData);
	}

	private boolean isInRadius(ChannelMember recipient, MessageContext ctx, ChannelData channelData) {
		Player recipientPlayer = Bukkit.getPlayer(recipient.id());
		Player authorPlayer = Bukkit.getPlayer(ctx.author().id());

		if (recipientPlayer == null || authorPlayer == null) {
			return false;
		}

		int radio = channelData.options()
				.condition(RadialChannelCondition.class)
				.as(int.class);

		return recipientPlayer.getLocation().distanceSquared(authorPlayer.getLocation()) <= radio;
	}
}

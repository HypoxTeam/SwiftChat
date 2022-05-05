package team.hypox.chat.spigot.condition;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

public class RadialChannelCondition extends DecoratorChannelCondition {

	private final int radio;

	public RadialChannelCondition(ChannelCondition condition, int radio) {
		super(condition);
		this.radio = radio;
	}

	@Override
	public boolean canListen(ChannelMember recipient, MessageContext ctx) {
		return super.canListen(recipient, ctx) && isInRadius(recipient, ctx);
	}

	private boolean isInRadius(ChannelMember recipient, MessageContext ctx) {
		Player recipientPlayer = Bukkit.getPlayer(recipient.id());
		Player authorPlayer = Bukkit.getPlayer(ctx.author().id());

		if (recipientPlayer == null || authorPlayer == null) {
			return false;
		}

		return recipientPlayer.getLocation().distanceSquared(authorPlayer.getLocation()) <= radio;
	}
}

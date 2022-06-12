package team.hypox.chat.spigot.condition;

import org.bukkit.Bukkit;
import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

public class PermissionChannelCondition extends DecoratorChannelCondition {

	public static PermissionChannelCondition withoutDecorates() {
		return new PermissionChannelCondition(new EndDecorator());
	}

	public PermissionChannelCondition(ChannelCondition condition) {
		super(condition);
	}

	@Override
	public boolean canListen(ChannelMember recipient, MessageContext ctx, ChannelData channelData) {
		String permission = channelData.options()
				.condition(PermissionChannelCondition.class)
				.as(String.class);

		return super.canListen(recipient, ctx, channelData) && Bukkit.getPlayer(recipient.id()).hasPermission(permission);
	}
}

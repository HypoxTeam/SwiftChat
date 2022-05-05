package team.hypox.chat.spigot.condition;

import org.bukkit.Bukkit;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelCondition;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

public class PermissionChannelCondition extends DecoratorChannelCondition {

	private final String permission;

	public PermissionChannelCondition(ChannelCondition condition, String permission) {
		super(condition);
		this.permission = permission;
	}

	@Override
	public boolean canListen(ChannelMember recipient, MessageContext ctx) {
		return super.canListen(recipient, ctx) && Bukkit.getPlayer(recipient.id()).hasPermission(permission);
	}
}

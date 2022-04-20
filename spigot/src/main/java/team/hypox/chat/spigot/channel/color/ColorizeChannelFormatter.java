package team.hypox.chat.spigot.channel.color;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import team.hypox.chat.core.channel.ChannelFormatter;
import team.hypox.chat.core.channel.decorator.DecoratorChannelFormatter;
import team.hypox.chat.core.message.MessageContext;

public class ColorizeChannelFormatter extends DecoratorChannelFormatter {

	public ColorizeChannelFormatter(ChannelFormatter formatter) {
		super(formatter);
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx) {
		return colorize(super.formatMessage(ctx));
	}

	private MessageContext colorize(MessageContext ctx) {
		if (Bukkit.getPlayer(ctx.author().id()).hasPermission("swiftchat.colors")) {
			ctx.formatMessage(ChatColor.translateAlternateColorCodes('&', ctx.formattedMessage()));
		}

		return ctx;
	}
}

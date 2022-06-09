package team.hypox.chat.spigot.format;

import org.bukkit.ChatColor;
import team.hypox.chat.core.structure.channel.ChannelFormatter;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelFormatter;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;
import team.hypox.chat.spigot.settings.mention.MentionSettings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MentionChannelFormatter extends DecoratorChannelFormatter {

	private final static Pattern MENTION_REGEX = Pattern.compile("@.([a-zA-Z0-9_\\-.]+)");
	private final MentionSettings mentionService;

	public static ChannelFormatter withoutDecorators(MentionSettings settings) {
		return new MentionChannelFormatter(new EndDecorator(), settings);
	}

	public MentionChannelFormatter(ChannelFormatter formatter, MentionSettings mentionService) {
		super(formatter);
		this.mentionService = mentionService;
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
		return formatMention(super.formatMessage(ctx, recipient), recipient);
	}

	private MessageContext formatMention(MessageContext ctx, ChannelMember recipient) {
		String formattedMessage = ctx.formattedMessage();

		Matcher matcher = MENTION_REGEX.matcher(formattedMessage);
		StringBuffer buffer = new StringBuffer();

		while (matcher.find()) {
			String userMentioned = matcher.group().substring(1);

			if (userMentioned.equalsIgnoreCase(recipient.name())) {
				mentionService.execute(recipient);

				matcher.appendReplacement(
						buffer,
						mentionService.colorize() + "@" + userMentioned + ChatColor.getLastColors(ctx.formattedMessage())
				);
			}
		}

		matcher.appendTail(buffer);
		ctx.formatMessage(buffer.toString());
		return ctx;
	}
}

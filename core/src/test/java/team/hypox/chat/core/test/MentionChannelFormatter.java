package team.hypox.chat.core.test;

import team.hypox.chat.core.structure.channel.ChannelFormatter;
import team.hypox.chat.core.structure.channel.decorator.DecoratorChannelFormatter;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MentionChannelFormatter extends DecoratorChannelFormatter {
	public MentionChannelFormatter(ChannelFormatter formatter) {
		super(formatter);
	}

	private final static Pattern MENTION_REGEX = Pattern.compile("@.([a-zA-Z0-9_\\-.]+)");

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
				matcher.appendReplacement(buffer, "-> MENTIONED YOU <-");
			}
		}

		matcher.appendTail(buffer);

		ctx.formatMessage(buffer.toString());
		return ctx;
	}
}

package team.hypox.chat.spigot.format;

import team.hypox.chat.core.channel.ChannelFormatter;
import team.hypox.chat.core.channel.decorator.DecoratorChannelFormatter;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;
import team.hypox.chat.spigot.member.MemberSettings;
import team.hypox.chat.spigot.settings.censure.CensureSettings;

public class PersonalCensureChannelFormatter extends DecoratorChannelFormatter {

	private final CensureSettings censureSettings;
	private final MemberSettings memberSettings;

	public PersonalCensureChannelFormatter(ChannelFormatter formatter, CensureSettings censureSettings, MemberSettings memberSettings) {
		super(formatter);
		this.censureSettings = censureSettings;
		this.memberSettings = memberSettings;
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx, ChannelMember recipient) {
		return censure(super.formatMessage(ctx, recipient), recipient);
	}

	private MessageContext censure(MessageContext ctx, ChannelMember recipient) {
		if (!memberSettings.censureBadWords(recipient)) {
			return ctx;
		}

		String censuredMessage = ctx.formattedMessage();

		for (String censuredWord : censureSettings.censuredWords()) {
			censuredMessage = censuredMessage.replace(censuredWord, censureSettings.replaceWord());
		}

		ctx.formatMessage(censuredMessage);
		return ctx;
	}
}

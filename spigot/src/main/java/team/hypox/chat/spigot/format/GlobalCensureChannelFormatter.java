package team.hypox.chat.spigot.format;

import team.hypox.chat.core.channel.ChannelFormatter;
import team.hypox.chat.core.channel.decorator.DecoratorChannelFormatter;
import team.hypox.chat.core.message.MessageContext;
import team.hypox.chat.spigot.settings.censure.CensureSettings;

public class GlobalCensureChannelFormatter extends DecoratorChannelFormatter {

	private final CensureSettings censureSettings;

	public GlobalCensureChannelFormatter(ChannelFormatter formatter, CensureSettings censureSettings) {
		super(formatter);
		this.censureSettings = censureSettings;
	}

	@Override
	public MessageContext formatMessage(MessageContext ctx) {
		return censure(super.formatMessage(ctx));
	}

	private MessageContext censure(MessageContext ctx) {
		String censuredMessage = ctx.formattedMessage();

		for (String censuredWord : censureSettings.censuredWords()) {
			censuredMessage = censuredMessage.replace(censuredWord, censureSettings.replaceWord());
		}

		ctx.formatMessage(censuredMessage);
		return ctx;
	}

}

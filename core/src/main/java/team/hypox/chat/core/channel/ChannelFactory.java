package team.hypox.chat.core.channel;

import team.hypox.chat.core.extend.AudienceNamespace;
import team.hypox.chat.core.extend.DecoratorNamespace;
import team.hypox.chat.core.structure.channel.Channel;

public class ChannelFactory {

	private final DecoratorNamespace decoratorNamespace;
	private final AudienceNamespace audienceNamespace;

	public ChannelFactory(DecoratorNamespace namespace, AudienceNamespace audienceNamespace) {
		this.decoratorNamespace = namespace;
		this.audienceNamespace = audienceNamespace;
	}

	public Channel from(ChannelData data) {
		Channel channel = new SampleChannel(
				data,
				audienceNamespace.using(data),
				decoratorNamespace.usingManyFormatters(data.getFormatters()),
				decoratorNamespace.usingManyConditions(data.getConditionals())
		);

		return channel;
	}
}

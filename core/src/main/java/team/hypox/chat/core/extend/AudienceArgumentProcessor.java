package team.hypox.chat.core.extend;

import team.hypox.chat.core.channel.ChannelData;

import java.util.function.Function;

public interface AudienceArgumentProcessor {

	default Object processArgument(ChannelData data) {
		return processArgument(data.getAudienceType(), data.getAudienceArgument());
	}

	Object processArgument(String audienceType, Object arg);

	void addProcessor(String type, Function<Object, Object> processor);

}

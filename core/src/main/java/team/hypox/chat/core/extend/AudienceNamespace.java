package team.hypox.chat.core.extend;

import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.util.AudienceProvider;

import java.util.function.Function;

public interface AudienceNamespace {

	AudienceArgumentProcessor argumentProcessor();

	default AudienceProvider using(ChannelData data) {
		return using(
				data.getAudienceType(),
				argumentProcessor().processArgument(data)
		);
	}

	default AudienceProvider using(String namespace) {
		return using(namespace, null);
	}

	<T> AudienceProvider using(String namespace, T argument);

	AudienceNamespace use(String namespace, Function<Object, AudienceProvider> factory);

}

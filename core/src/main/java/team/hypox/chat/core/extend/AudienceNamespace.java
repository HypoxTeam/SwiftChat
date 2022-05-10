package team.hypox.chat.core.extend;

import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.util.AudienceProvider;

import java.util.function.Function;

public interface AudienceNamespace {

	/**
	 * @return The actual argument processor
	 */
	AudienceArgumentProcessor argumentProcessor();

	/**
	 * Use the audience provider linked to the Channel Data
	 * @param data Channel Data with the audience type and argument
	 * @return the audience provider stored in the namespace
	 */
	default AudienceProvider using(ChannelData data) {
		return using(
				data.getAudienceType(),
				argumentProcessor().processArgument(data)
		);
	}

	/**
	 * Use the audience provider linked to the namespace with NULL as argument
	 * @param namespace Namespace id
	 * @return the audience provider stored in the namespace
	 */
	default AudienceProvider using(String namespace) {
		return using(namespace, null);
	}

	/**
	 * Use the audience provider linked to the namespace
	 * @param namespace Namespace id
	 * @param argument argument to process the audience provider
	 * @param <T> argument type
	 * @return the audience provider stored in the namespace
	 */
	<T> AudienceProvider using(String namespace, T argument);

	/**
	 * Register the AudienceProvider with the argument
	 * @param namespace Namespace id
	 * @param factory the audience provider creator
	 * @return the actual audience namespace
	 */
	AudienceNamespace use(String namespace, Function<Object, AudienceProvider> factory);

}

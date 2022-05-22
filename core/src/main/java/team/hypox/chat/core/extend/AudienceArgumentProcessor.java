package team.hypox.chat.core.extend;

import team.hypox.chat.core.channel.ChannelData;

import java.util.function.Function;

public interface AudienceArgumentProcessor {

	/**
	 * Process the argument of the channel data
	 * @param data Channel Data to process
	 * @return the argument processed
	 */
	default Object processArgument(ChannelData data) {
		return processArgument(data.getAudienceProcessor(), data.getAudienceArgument());
	}

	/**
	 * Process the argument
	 * @param audienceType the type of argument processor
	 * @param arg the argument to process
	 * @return the argument processed
	 */
	Object processArgument(String audienceType, Object arg);

	/**
	 * Register a new Argument Processor
	 * this method throws a IllegalArgumentException if the argument type is already registered
	 * @param type the type of argument processor
	 * @param processor the argument processor
	 */
	AudienceArgumentProcessor addProcessor(String type, Function<Object, Object> processor);

}

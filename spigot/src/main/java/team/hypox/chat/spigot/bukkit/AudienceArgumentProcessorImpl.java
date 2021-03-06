package team.hypox.chat.spigot.bukkit;

import team.hypox.chat.core.commons.Condition;
import team.hypox.chat.core.extend.AudienceArgumentProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class AudienceArgumentProcessorImpl implements AudienceArgumentProcessor {

	private final Map<String, Function<Object, Object>> processors = new HashMap<>();

	@Override
	public Object processArgument(String type, Object arg) {
		return processors.getOrDefault(type, Processors.ANYTHING).apply(arg);
	}

	@Override
	public AudienceArgumentProcessor addProcessor(String type, Function<Object, Object> processor) {
		Condition.needNull(
				processors.get(type),
				"Processor with the type %s is already registered", type
		);

		processors.put(type, processor);
		return this;
	}
}

package team.hypox.chat.spigot.bukkit;

import org.bukkit.Bukkit;
import team.hypox.chat.core.commons.Condition;
import team.hypox.chat.core.extend.AudienceArgumentProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class AudienceArgumentProcessorImpl implements AudienceArgumentProcessor {

	private final Map<String, Function<Object, Object>> processors = new HashMap<>();

	public AudienceArgumentProcessorImpl() {
		processors.put("world", o -> Bukkit.getWorld((String) o));
	}

	@Override
	public Object processArgument(String type, Object arg) {
		return processors.get(type).apply(arg);
	}

	@Override
	public void addProcessor(String type, Function<Object, Object> processor) {
		Condition.expects(
				processors.get(type) == null,
				"Processor with the type %s is already registered", type
		);

		processors.put(type, processor);
	}
}

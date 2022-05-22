package team.hypox.chat.spigot.bukkit;

import team.hypox.chat.core.extend.AudienceArgumentProcessor;
import team.hypox.chat.core.extend.AudienceNamespace;
import team.hypox.chat.core.util.AudienceProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class AudienceFactory implements AudienceNamespace {

	private final AudienceArgumentProcessor argumentProcessor;

	private final Map<String, Function<Object, AudienceProvider>> namespaces = new HashMap<>();

	public AudienceFactory(AudienceArgumentProcessor argumentProcessor) {
		this.argumentProcessor = argumentProcessor;
	}

	@Override
	public AudienceArgumentProcessor argumentProcessor() {
		return argumentProcessor;
	}

	@Override
	public <T> AudienceProvider using(String namespace, T consumer) {
		return namespaces.get(namespace).apply(consumer);
	}

	@Override
	public AudienceNamespace use(String namespace, Function<Object, AudienceProvider> factory) {
		namespaces.put(namespace, factory);
		return this;
	}

}

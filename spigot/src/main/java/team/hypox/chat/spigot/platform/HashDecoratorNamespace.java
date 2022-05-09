package team.hypox.chat.spigot.platform;

import team.hypox.chat.core.extend.DecoratorNamespace;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.ChannelFormatter;

import java.util.HashMap;
import java.util.Map;

public class HashDecoratorNamespace implements DecoratorNamespace {

	private final Map<Class<? extends ChannelCondition>, ChannelCondition> conditionNamespace = new HashMap<>();
	private final Map<Class<? extends ChannelFormatter>, ChannelFormatter> formatterNamespace = new HashMap<>();

	@Override
	public ChannelCondition usingCondition(Class<? extends ChannelCondition> condition) {
		return conditionNamespace.get(condition);
	}

	@Override
	public ChannelFormatter usingFormatter(Class<? extends ChannelFormatter> formatter) {
		return formatterNamespace.get(formatter);
	}

	@Override
	public DecoratorNamespace use(Class<? extends ChannelCondition> clazz, ChannelCondition condition) {
		conditionNamespace.put(clazz, condition);
		return this;
	}

	@Override
	public DecoratorNamespace use(Class<? extends ChannelFormatter> clazz, ChannelFormatter formatter) {
		formatterNamespace.put(clazz, formatter);
		return this;
	}
}

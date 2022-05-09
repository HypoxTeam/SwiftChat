package team.hypox.chat.core.extend;

import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.ChannelFormatter;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public interface DecoratorNamespace {

	ChannelCondition usingCondition(Class<? extends ChannelCondition> condition);
	ChannelFormatter usingFormatter(Class<? extends ChannelFormatter> formatter);

	DecoratorNamespace use(Class<? extends ChannelCondition> clazz, ChannelCondition condition);
	DecoratorNamespace use(Class<? extends ChannelFormatter> clazz, ChannelFormatter formatter);

	Iterator<Class<? extends ChannelCondition>> namespaceCondition();
	Iterator<Class<? extends ChannelFormatter>> namespaceFormatter();

	default List<ChannelCondition> usingManyConditions(List<Class<? extends ChannelCondition>> condition) {
		return condition.stream()
				.map(this::usingCondition)
				.collect(Collectors.toList());
	}

	default List<ChannelFormatter> usingManyFormatters(List<Class<? extends ChannelFormatter>> formatter) {
		return formatter.stream()
				.map(this::usingFormatter)
				.collect(Collectors.toList());
	}

}

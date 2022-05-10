package team.hypox.chat.core.extend;

import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.ChannelFormatter;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public interface DecoratorNamespace {

	/**
	 * Use the Channel Condition in the namespace
	 * null if the namespace dont have the class
	 * @param condition Channel Condition
	 * @return namespaced Channel Condition
	 */
	ChannelCondition usingCondition(Class<? extends ChannelCondition> condition);

	/**
	 * Use the Channel Formatter in the namespace
	 * null if the namespace dont have the class
	 * @param formatter Channel Formatter
	 * @return namespaced Channel Formatter
	 */
	ChannelFormatter usingFormatter(Class<? extends ChannelFormatter> formatter);

	/**
	 * Register the Channel Condition in the namespace
	 * @param clazz namespace
	 * @param condition value
	 * @return the actual namespace decorator
	 */
	DecoratorNamespace use(Class<? extends ChannelCondition> clazz, ChannelCondition condition);

	/**
	 * Register the Channel Formatter in the namespace
	 * @param clazz namespace
	 * @param formatter value
	 * @return the actual namespace decorator
	 */
	DecoratorNamespace use(Class<? extends ChannelFormatter> clazz, ChannelFormatter formatter);

	/**
	 * @return the all namespaces iterator
	 */
	Iterator<Class<? extends ChannelCondition>> namespaceCondition();

	/**
	 * @return the all namespaces iterator
	 */
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

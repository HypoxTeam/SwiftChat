package team.hypox.chat.core.extend;

import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.ChannelFormatter;

public interface DecoratorNamespace {

	ChannelCondition usingCondition(Class<? extends ChannelCondition> condition);
	ChannelFormatter usingFormatter(Class<? extends ChannelFormatter> formatter);

	DecoratorNamespace use(Class<? extends ChannelCondition> clazz, ChannelCondition condition);
	DecoratorNamespace use(Class<? extends ChannelFormatter> clazz, ChannelFormatter formatter);

}

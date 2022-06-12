package team.hypox.chat.core.channel.option;

import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.ChannelFormatter;

import java.util.HashMap;
import java.util.Map;

public class ChannelOptions {

	private final Map<Class<? extends ChannelFormatter>, ChannelOptionContext> formatterOptions = new HashMap<>();
	private final Map<Class<? extends ChannelCondition>, ChannelOptionContext> conditionOptions = new HashMap<>();

	public ChannelOptionContext condition(Class<? extends ChannelCondition> clazz) {
		return conditionOptions.get(clazz);
	}

	public ChannelOptionContext formatter(Class<? extends  ChannelFormatter> clazz) {
		return formatterOptions.get(clazz);
	}

}

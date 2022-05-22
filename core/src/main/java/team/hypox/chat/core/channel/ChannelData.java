package team.hypox.chat.core.channel;

import lombok.Builder;
import lombok.Getter;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.ChannelFormatter;

import java.util.List;

@Getter
@Builder(setterPrefix = "", builderMethodName = "with")
public class ChannelData {

	private final String name;
	private final String template;
	private final String audienceType;
	private final String audienceArgument;
	private final String audienceProcessor;
	private final List<Class<? extends ChannelCondition>> conditionals;
	private final List<Class<? extends ChannelFormatter>> formatters;

	public boolean isTemplated() {
		return template != null;
	}

}

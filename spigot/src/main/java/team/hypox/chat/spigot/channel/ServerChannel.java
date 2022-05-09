package team.hypox.chat.spigot.channel;

import com.google.common.collect.Lists;
import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.structure.channel.AbstractChannel;
import team.hypox.chat.core.util.ChannelMemberList;
import team.hypox.chat.spigot.bukkit.AudienceFactory;

public class ServerChannel extends AbstractChannel {

	private final AudienceFactory audienceFactory;

	public ServerChannel(AudienceFactory audienceFactory) {
		super(
				ChannelData.with()
						.name("server")
						.conditionals(Lists.newArrayList())
						.formatters(Lists.newArrayList())
						.build()
		);
		this.audienceFactory = audienceFactory;
	}

	@Override
	protected ChannelMemberList audience() {
		return audienceFactory.server().invoke();
	}
}

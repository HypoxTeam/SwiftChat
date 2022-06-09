package team.hypox.chat.spigot.channel;

import com.google.common.collect.Lists;
import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.extend.AudienceNamespace;
import team.hypox.chat.core.structure.channel.AbstractChannel;
import team.hypox.chat.core.util.ChannelMemberList;

public class ServerChannel extends AbstractChannel {

	private final AudienceNamespace audienceNamespace;

	public ServerChannel(AudienceNamespace audienceNamespace) {
		super(
				ChannelData.with()
						.name("server_global")
						.conditionals(Lists.newArrayList())
						.formatters(Lists.newArrayList())
						.build()
		);
		this.audienceNamespace = audienceNamespace;
	}

	@Override
	protected ChannelMemberList audience() {
		return audienceNamespace.using("server_global").invoke();
	}
}

package team.hypox.chat.spigot.channel;

import team.hypox.chat.core.structure.channel.AbstractChannel;
import team.hypox.chat.core.util.ChannelMemberList;
import team.hypox.chat.spigot.bukkit.AudienceFactory;

public class ServerChannel extends AbstractChannel {

	private final AudienceFactory audienceFactory;

	public ServerChannel(AudienceFactory audienceFactory) {
		this.audienceFactory = audienceFactory;
	}

	@Override
	protected ChannelMemberList audience() {
		return audienceFactory.server().invoke();
	}
}

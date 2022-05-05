package team.hypox.chat.spigot.channel;

import team.hypox.chat.core.structure.channel.AbstractChannel;
import team.hypox.chat.core.util.ChannelMemberList;
import team.hypox.chat.spigot.bukkit.AudienceProvider;

public class ServerChannel extends AbstractChannel {

	private final AudienceProvider audienceProvider;

	public ServerChannel(AudienceProvider audienceProvider) {
		this.audienceProvider = audienceProvider;
	}

	@Override
	protected ChannelMemberList audience() {
		return audienceProvider.audience();
	}
}

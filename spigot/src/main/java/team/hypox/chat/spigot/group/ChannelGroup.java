package team.hypox.chat.spigot.group;

import lombok.experimental.Delegate;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ChannelGroup {

	@Delegate
	private final Set<UUID> members = new HashSet<>();

}

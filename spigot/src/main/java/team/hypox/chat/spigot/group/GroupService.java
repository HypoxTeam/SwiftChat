package team.hypox.chat.spigot.group;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GroupService {

	private final Map<UUID, ChannelGroup> groups = new HashMap<>();

	public ChannelGroup findGroup(UUID groupId) {
		return groups.get(groupId);
	}

}

package team.hypox.chat.member.cache;

import org.bukkit.entity.Player;
import team.hypox.chat.member.ChannelMember;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MemberCache {

	private final Map<UUID, ChannelMember> members = new HashMap<>();

	public ChannelMember find(Player player) {
		return find(player.getUniqueId());
	}

	public ChannelMember find(UUID id) {
		return members.get(id);
	}

}

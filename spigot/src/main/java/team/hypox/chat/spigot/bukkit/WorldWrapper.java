package team.hypox.chat.spigot.bukkit;

import lombok.Data;
import lombok.experimental.Delegate;
import org.bukkit.World;
import org.bukkit.entity.Player;
import team.hypox.chat.core.member.cache.MemberCache;
import team.hypox.chat.core.util.ChannelMemberList;

import java.util.stream.Collectors;

@Data
public class WorldWrapper implements World {

	@Delegate
	private final World world;
	private final MemberCache<Player> memberCache;

	public ChannelMemberList audience() {
		return world.getPlayers().stream()
				.map(memberCache::find)
				.collect(Collectors.toCollection(ChannelMemberList::new));
	}

}

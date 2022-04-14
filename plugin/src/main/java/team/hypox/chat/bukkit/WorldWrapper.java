package team.hypox.chat.bukkit;

import lombok.Data;
import lombok.experimental.Delegate;
import org.bukkit.World;
import team.hypox.chat.member.cache.MemberCache;
import team.hypox.chat.util.ChannelMemberList;

import java.util.stream.Collectors;

@Data
public class WorldWrapper implements World {

	@Delegate
	private final World world;
	private final MemberCache memberCache;

	public ChannelMemberList audience() {
		return world.getPlayers().stream()
				.map(memberCache::find)
				.collect(Collectors.toCollection(ChannelMemberList::new));
	}

}

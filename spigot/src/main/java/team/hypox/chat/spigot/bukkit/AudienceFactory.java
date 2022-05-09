package team.hypox.chat.spigot.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import team.hypox.chat.core.structure.member.cache.MemberCache;
import team.hypox.chat.core.util.AudienceProvider;
import team.hypox.chat.core.util.ChannelMemberList;

import java.util.stream.Collectors;


public class AudienceFactory {

	private final MemberCache<Player> memberCache;

	public AudienceFactory(MemberCache<Player> memberCache) {
		this.memberCache = memberCache;
	}

	public AudienceProvider server() {
		return () -> Bukkit.getServer().getOnlinePlayers().stream()
				.map(memberCache::find)
				.collect(Collectors.toCollection(ChannelMemberList::empty));
	}

	public AudienceProvider world(World world) {
		return () -> world.getPlayers().stream()
				.map(memberCache::find)
				.collect(Collectors.toCollection(ChannelMemberList::empty));
	}

}

package team.hypox.chat.spigot.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import team.hypox.chat.core.member.cache.MemberCache;
import team.hypox.chat.core.util.ChannelMemberList;

import java.util.stream.Collectors;


public class AudienceProvider {

	private final MemberCache<Player> memberCache;

	public AudienceProvider(MemberCache<Player> memberCache) {
		this.memberCache = memberCache;
	}

	public ChannelMemberList audience() {
		return Bukkit.getServer().getOnlinePlayers().stream()
				.map(memberCache::find)
				.collect(Collectors.toCollection(ChannelMemberList::empty));
	}

	public ChannelMemberList audience(World world) {
		return world.getPlayers().stream()
				.map(memberCache::find)
				.collect(Collectors.toCollection(ChannelMemberList::empty));
	}

}

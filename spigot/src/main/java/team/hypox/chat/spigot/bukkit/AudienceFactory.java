package team.hypox.chat.spigot.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import team.hypox.chat.core.extend.AudienceArgumentProcessor;
import team.hypox.chat.core.extend.AudienceNamespace;
import team.hypox.chat.core.structure.member.cache.MemberCache;
import team.hypox.chat.core.util.AudienceProvider;
import team.hypox.chat.core.util.ChannelMemberList;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class AudienceFactory implements AudienceNamespace {

	private final MemberCache<Player> memberCache;
	private final AudienceArgumentProcessor argumentProcessor;

	private final Map<String, Function<Object, AudienceProvider>> namespaces = new HashMap<>();

	public AudienceFactory(MemberCache<Player> memberCache, AudienceArgumentProcessor argumentProcessor) {
		this.memberCache = memberCache;
		this.argumentProcessor = argumentProcessor;

		namespaces.put("server", (unused) -> server());
		namespaces.put("world", (world) -> world((World) world));
	}

	@Override
	public AudienceArgumentProcessor argumentProcessor() {
		return argumentProcessor;
	}

	@Override
	public <T> AudienceProvider using(String namespace, T consumer) {
		return namespaces.get(namespace).apply(consumer);
	}

	@Override
	public AudienceNamespace use(String namespace, Function<Object, AudienceProvider> factory) {
		namespaces.put(namespace, factory);
		return this;
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

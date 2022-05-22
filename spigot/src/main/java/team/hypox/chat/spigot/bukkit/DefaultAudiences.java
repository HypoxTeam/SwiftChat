package team.hypox.chat.spigot.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import team.hypox.chat.core.extend.AudienceNamespace;
import team.hypox.chat.core.structure.member.cache.MemberCache;
import team.hypox.chat.core.util.AudienceProvider;
import team.hypox.chat.core.util.ChannelMemberList;
import team.hypox.chat.spigot.group.GroupService;

import java.util.UUID;
import java.util.stream.Collectors;

public class DefaultAudiences {

	private final MemberCache memberCache;
	private final GroupService groupService;

	public DefaultAudiences(AudienceNamespace namespace, MemberCache memberCache, GroupService groupService) {
		this.memberCache = memberCache;
		this.groupService = groupService;

		namespace
				.use("world", world -> world((World) world))
				.use("server_global", unused -> server())
				.use("groupId", groupUUID -> group((UUID) groupUUID))
				.argumentProcessor()
				.addProcessor("world", Processors.WORLD)
				.addProcessor("id", Processors.ID);
	}

	private AudienceProvider group(UUID groupId) {
		return () -> groupService.findGroup(groupId).stream()
				.map(memberCache::find)
				.collect(Collectors.toCollection(ChannelMemberList::empty));
	}

	private AudienceProvider server() {
		return () -> Bukkit.getServer().getOnlinePlayers().stream()
				.map(Player::getUniqueId)
				.map(memberCache::find)
				.collect(Collectors.toCollection(ChannelMemberList::empty));
	}

	private AudienceProvider world(World world) {
		return () -> world.getPlayers().stream()
				.map(Player::getUniqueId)
				.map(memberCache::find)
				.collect(Collectors.toCollection(ChannelMemberList::empty));
	}

}

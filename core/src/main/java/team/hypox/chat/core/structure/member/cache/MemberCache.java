package team.hypox.chat.core.structure.member.cache;

import team.hypox.chat.core.structure.member.ChannelMember;

import java.util.UUID;

public interface MemberCache<Player> {

	ChannelMember find(Player player);

	ChannelMember find(UUID id);

}

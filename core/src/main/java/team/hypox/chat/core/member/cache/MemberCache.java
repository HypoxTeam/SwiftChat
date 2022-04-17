package team.hypox.chat.core.member.cache;

import team.hypox.chat.core.member.ChannelMember;

import java.util.UUID;

public interface MemberCache<Player> {

	ChannelMember find(Player player);

	ChannelMember find(UUID id);

}

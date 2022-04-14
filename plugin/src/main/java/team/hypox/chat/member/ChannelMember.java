package team.hypox.chat.member;

import net.md_5.bungee.api.chat.TextComponent;

import java.util.UUID;

public interface ChannelMember {

	UUID id();

	ChannelMemberPreferences preferences();

	void sendMessage(TextComponent message);

}

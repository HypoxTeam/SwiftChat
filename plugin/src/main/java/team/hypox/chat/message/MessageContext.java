package team.hypox.chat.message;

import net.md_5.bungee.api.chat.TextComponent;
import team.hypox.chat.member.ChannelMember;

public interface MessageContext {

	TextComponent content();

	ChannelMember author();

}

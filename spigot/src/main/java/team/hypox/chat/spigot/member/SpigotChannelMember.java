package team.hypox.chat.spigot.member;

import lombok.Data;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.member.ChannelMemberPreferences;
import team.hypox.chat.core.message.MessageContext;
import team.hypox.chat.core.message.MessageContext.MessageContent;

import java.util.UUID;

@Data
public class SpigotChannelMember implements ChannelMember {

	private final UUID id;
	private final ChannelMemberPreferences preferences;

	@Override
	public UUID id() {
		return id;
	}

	@Override
	public ChannelMemberPreferences preferences() {
		return preferences;
	}

	@Override
	public void sendMessage(MessageContext message) {
		MessageContent<TextComponent> content = (MessageContent<TextComponent>) message.content();

		bukkit().spigot().sendMessage(content.get());
	}

	public Player bukkit() {
		return Bukkit.getPlayer(id);
	}
}

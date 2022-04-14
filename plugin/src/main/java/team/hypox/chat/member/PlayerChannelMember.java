package team.hypox.chat.member;

import lombok.Data;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@Data
public class PlayerChannelMember implements ChannelMember {

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
	public void sendMessage(TextComponent message) {
		bukkit().spigot().sendMessage(message);
	}

	public Player bukkit() {
		return Bukkit.getPlayer(id);
	}
}

package team.hypox.chat.spigot.member;

import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.member.ChannelMemberPreferences;
import team.hypox.chat.core.message.MessageContext;
import team.hypox.chat.spigot.util.Text;

import java.util.UUID;

@Data
public class SpigotChannelMember implements ChannelMember {

	private final UUID id;
	private final ChannelMemberPreferences preferences;

	@Override
	public String name() {
		return bukkit().getName();
	}

	@Override
	public UUID id() {
		return id;
	}

	@Override
	public void sendMessage(MessageContext message) {
		bukkit().spigot().sendMessage(Text.parse(message.formattedMessage()));
	}

	public Player bukkit() {
		return Bukkit.getPlayer(id);
	}
}

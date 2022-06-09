package team.hypox.chat.spigot.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import team.hypox.chat.core.structure.member.ChannelMember;

public class BukkitAdapter {

	public static Player adapt(ChannelMember member) {
		return Bukkit.getPlayer(member.id());
	}

}

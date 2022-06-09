package team.hypox.chat.spigot.settings.mention;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import team.hypox.chat.core.configuration.Configuration;
import team.hypox.chat.core.configuration.ConfigurationFactory;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.spigot.bukkit.BukkitAdapter;

public class MentionSettings {

	private final Configuration config;

	public MentionSettings(ConfigurationFactory factory) {
		this.config = factory.create("mention-settings.yml");
	}

	public String colorize() {
		return config.getString("color");
	}

	public void execute(ChannelMember mentioned) {
		Player player = BukkitAdapter.adapt(mentioned);

		player.sendMessage(config.getString("alert-message"));
		player.playSound(player.getLocation(), Sound.valueOf(config.getString("alert-sound")), 50, 50);
	}

}

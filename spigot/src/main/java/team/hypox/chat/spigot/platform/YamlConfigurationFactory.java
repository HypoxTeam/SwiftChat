package team.hypox.chat.spigot.platform;

import org.bukkit.plugin.Plugin;
import team.hypox.chat.core.configuration.Configuration;
import team.hypox.chat.core.configuration.ConfigurationFactory;
import team.hypox.chat.spigot.bukkit.BukkitConfiguration;

public class YamlConfigurationFactory implements ConfigurationFactory {

	private final Plugin plugin;

	public YamlConfigurationFactory(Plugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public Configuration create(String name) {
		return new BukkitConfiguration(plugin, name);
	}

}

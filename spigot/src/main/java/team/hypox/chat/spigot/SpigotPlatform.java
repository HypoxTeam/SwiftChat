package team.hypox.chat.spigot;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import team.hypox.chat.core.SwiftChatPlatform;
import team.hypox.chat.spigot.platform.ChannelCacheContainer;
import team.hypox.chat.spigot.platform.HashDecoratorNamespace;
import team.hypox.chat.spigot.platform.YamlConfigurationFactory;

public class SpigotPlatform extends SwiftChatPlatform {

	public static String PLATFORM_NAME;
	private final JavaPlugin plugin;

	public SpigotPlatform(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	protected void setup() {
		PLATFORM_NAME = plugin.getName();

		this.channelContainer = new ChannelCacheContainer();
		this.decoratorNamespace = new HashDecoratorNamespace();
		this.configurationFactory = new YamlConfigurationFactory(plugin);
	}

	public static boolean isSwiftChat(Plugin plugin) {
		return plugin.getName().equals(PLATFORM_NAME);
	}

}

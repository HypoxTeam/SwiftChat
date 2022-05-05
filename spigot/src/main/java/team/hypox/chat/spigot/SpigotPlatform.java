package team.hypox.chat.spigot;

import org.bukkit.plugin.java.JavaPlugin;
import team.hypox.chat.core.SwiftChatPlatform;
import team.hypox.chat.spigot.platform.ChannelCacheContainer;

public class SpigotPlatform extends SwiftChatPlatform {

	private final JavaPlugin plugin;

	public SpigotPlatform(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void setup() {
		this.channelContainer = new ChannelCacheContainer();
	}
}

package team.hypox.chat.spigot;

import org.bukkit.plugin.java.JavaPlugin;
import team.hypox.chat.core.SwiftChatPlatform;

public class ChatPlugin extends JavaPlugin {

	private final SwiftChatPlatform platform = new SpigotPlatform(this);

	@Override
	public void onEnable() {
		platform.enable();
	}
}

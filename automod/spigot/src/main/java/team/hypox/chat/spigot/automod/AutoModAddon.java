package team.hypox.chat.spigot.automod;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.java.JavaPlugin;
import team.hypox.chat.addon.automod.AutoModService;
import team.hypox.chat.addon.automod.toxicity.ToxicityCondition;
import team.hypox.chat.core.SwiftChatPlatform;
import team.hypox.chat.core.SwiftChatPlatformAccessor;
import team.hypox.chat.spigot.SpigotPlatform;

public class AutoModAddon extends JavaPlugin implements Listener {

	@EventHandler
	public void onInitializeSwiftChat(PluginEnableEvent event) {
		if (!SpigotPlatform.isSwiftChat(event.getPlugin())) {
			return;
		}

		SwiftChatPlatform platform = SwiftChatPlatformAccessor.access();
		AutoModService modService = new AutoModService(platform.configurationFactory());

		platform.decoratorNamespace()
				.use(ToxicityCondition.class, ToxicityCondition.withoutDecorator(modService));
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
}

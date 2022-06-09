package team.hypox.chat.spigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import team.hypox.chat.core.SwiftChatPlatform;
import team.hypox.chat.core.SwiftChatPlatformAccessor;
import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.structure.channel.Channel;
import team.hypox.chat.core.util.ChannelMemberList;
import team.hypox.chat.spigot.format.ColorizeChannelFormatter;
import team.hypox.chat.spigot.format.GlobalCensureChannelFormatter;

import java.util.Arrays;

public class AddonExample implements Listener {

	@EventHandler
	public void onSwiftChatInitialize(PluginEnableEvent event) {
		//Check if the plugin is SwiftChat
		if (!SpigotPlatform.isSwiftChat(event.getPlugin())) {
			return;
		}

		//Access to swift-chat high-level platform
		SwiftChatPlatform platform = SwiftChatPlatformAccessor.access();

		//Using SwiftChat configuration factory to create config files inside SwiftChat

		//Using platform decorator namespace to register ChannelConditions or Formatters
		platform.decoratorNamespace()
				.use(ColorizeChannelFormatter.class, ColorizeChannelFormatter.withoutDecorates());

		platform.audienceNamespace()
				//Register audience provider namespace
				.use("empty", unused -> ChannelMemberList::empty)
				.argumentProcessor()
				//Add argument processor for use when the provider is queried
				.addProcessor("empty", unused -> unused);

		//Creating a new blank channel

		//Create the channel data (for serializing)
		ChannelData channelData = ChannelData.with()
				.name("my-awesome-vip-club")
				.audienceType("empty")
				.formatters(Arrays.asList(ColorizeChannelFormatter.class, GlobalCensureChannelFormatter.class))
				.build();

		//Create the channel using the channel data
		Channel awesomeChannel = platform.channelFactory()
				.from(channelData);

		//Register the channel
		platform.channelContainer()
				//Register new channel
				.register(awesomeChannel)
				//Register channel overriding name
				.register("my-awesome-vip-club", awesomeChannel);
	}

}

# SwiftChat Spigot
SwiftChat-Spigot is a SwiftChat Platform implementation for Minecraft Servers. It grants the next level experience in chat design

## Extend SwiftChat
The common SwiftChat modules not enough for you?

### Extending with external plugin
```java
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
		AutoModService modService = new AutoModService(platform.configurationFactory());

		//Using platform decorator namespace to register ChannelConditions or Formatters
		platform.decoratorNamespace()
				.use(ColorizeChannelFormatter.class, ColorizeChannelFormatter.withoutDecorates())
				.use(ToxicityCondition.class, ToxicityCondition.withoutDecorator(modService));

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
				.conditionals(Arrays.asList(ToxicityCondition.class))
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
```

### Extending with the main core
You can contribute adding Channel Modules with pull requests!. All of the swiftchat users will be 
have access to your new modules

Start contributing [here](https://github.com/HypoxTeam/SwiftChat/pulls)

PS: if you want to contribute please follow the [code guide](https://github.com/HypoxTeam/SwiftChat/blob/main/code-guide.md)!

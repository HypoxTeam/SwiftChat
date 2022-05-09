# SwiftChat Spigot
SwiftChat-Spigot is a SwiftChat Platform implementation for Minecraft Servers. It grants the next level experience in chat design

## Extends SwiftChat
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
		
		//Access to swiftchat high-level platform
		SwiftChatPlatform platform = SwiftChatPlatformAccessor.access();
		
		//Using SwiftChat configuration factory to create config files inside SwiftChat
		AutoModService modService = new AutoModService(platform.configurationFactory());

		//Using platform decorator namespace to register ChannelConditions or Formatters
		platform.decoratorNamespace()
				.use(ToxicityCondition.class, ToxicityCondition.withoutDecorator(modService));

		//Creating a new blank channel
		Channel awesomeChannel = new SampleChannel(
				ChannelMemberList::empty,
				platform.decoratorNamespace()
						.usingFormatter(ColorizeChannelFormatter.class),
				platform.decoratorNamespace()
						.usingCondition(ToxicityCondition.class)
		);

		//Register the channel
		platform.channelContainer()
				.register("my-awesome-vip-club", awesomeChannel);
	}

}
```

package team.hypox.chat.spigot;

import org.bukkit.plugin.java.JavaPlugin;
import team.hypox.chat.core.SwiftChatPlatform;
import team.hypox.chat.spigot.bukkit.DefaultAudiences;
import team.hypox.chat.spigot.format.ColorizeChannelFormatter;
import team.hypox.chat.spigot.format.DotChannelFormatter;
import team.hypox.chat.spigot.format.GlobalCensureChannelFormatter;
import team.hypox.chat.spigot.format.MentionChannelFormatter;
import team.hypox.chat.spigot.format.PersonalCensureChannelFormatter;
import team.hypox.chat.spigot.group.GroupService;
import team.hypox.chat.spigot.member.MemberSettings;
import team.hypox.chat.spigot.settings.censure.CensureSettings;
import team.hypox.chat.spigot.settings.mention.MentionSettings;

public class ChatPlugin extends JavaPlugin {

	private final SwiftChatPlatform platform = new SpigotPlatform(this);

	@Override
	public void onEnable() {
		platform.enable();

		processDecorators();
	}

	private void processDecorators() {
		CensureSettings censureSettings = new CensureSettings(platform.configurationFactory());
		MentionSettings mentionSettings = new MentionSettings(platform.configurationFactory());

		new DefaultAudiences(platform.audienceNamespace(), platform.memberCache(), new GroupService());

		platform.decoratorNamespace()
				.use(ColorizeChannelFormatter.class, ColorizeChannelFormatter.withoutDecorates())
				.use(DotChannelFormatter.class, DotChannelFormatter.withoutDecorates())
				.use(MentionChannelFormatter.class, MentionChannelFormatter.withoutDecorators(mentionSettings))
				.use(GlobalCensureChannelFormatter.class, GlobalCensureChannelFormatter.withoutDecorates(censureSettings))
				.use(PersonalCensureChannelFormatter.class, PersonalCensureChannelFormatter.withoutDecorators(censureSettings, new MemberSettings()));
	}
}

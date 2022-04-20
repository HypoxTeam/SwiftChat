package team.hypox.chat.spigot.util;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

public class Text {

	public static BaseComponent[] parse(String text) {
		return TextComponent.fromLegacyText(text);
	}

}

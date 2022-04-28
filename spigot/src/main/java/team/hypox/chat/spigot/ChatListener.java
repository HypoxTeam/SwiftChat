package team.hypox.chat.spigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import team.hypox.chat.core.channel.Channel;
import team.hypox.chat.core.member.ChannelMember;

public class ChatListener implements Listener {

	private final ChatManager chatManager;

	public ChatListener(ChatManager chatManager) {
		this.chatManager = chatManager;
	}

	@EventHandler
	public void handleChannel(AsyncPlayerChatEvent event) {
		ChannelMember member = chatManager.from(event.getPlayer().getUniqueId());
		Channel currentChannel = chatManager.activeChannel(member);

		chatManager.sendMessage(currentChannel, member, event.getMessage());
	}

}

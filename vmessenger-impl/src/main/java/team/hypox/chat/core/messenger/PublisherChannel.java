package team.hypox.chat.core.messenger;

import net.ibxnjadev.vmessenger.universal.Messenger;
import team.hypox.chat.core.channel.AbstractChannel;
import team.hypox.chat.core.message.MessageContext;

public abstract class PublisherChannel extends AbstractChannel {

	private final Messenger messenger;

	protected PublisherChannel(Messenger messenger) {
		this.messenger = messenger;
	}

	@Override
	public void notifyMessage(MessageContext ctx) {
		messenger.sendMessage(ctx);
	}
}

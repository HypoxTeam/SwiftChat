package team.hypox.chat.core.messenger;

import net.ibxnjadev.vmessenger.universal.Interceptor;
import team.hypox.chat.core.channel.AbstractChannel;
import team.hypox.chat.core.message.MessageContext;

public abstract class SubscriberChannel
		extends AbstractChannel
		implements Interceptor<MessageContext>
{
	@Override
	public void subscribe(MessageContext object) {
		notifyMessage(object);
	}

}

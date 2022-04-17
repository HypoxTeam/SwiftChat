package team.hypox.chat.core.channel;

import team.hypox.chat.core.message.MessageContext;

public interface Channel {

	void notifyMessage(MessageContext ctx);

}

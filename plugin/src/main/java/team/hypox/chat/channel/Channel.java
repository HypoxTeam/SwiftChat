package team.hypox.chat.channel;

import team.hypox.chat.message.MessageContext;

public interface Channel {

	void notifyMessage(MessageContext ctx);

}

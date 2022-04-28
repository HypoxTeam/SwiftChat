package team.hypox.chat.core.messenger;

import team.hypox.chat.core.message.MessageContext;

public interface ProxyMessageContext extends MessageContext {

	String getOriginalServer();

}

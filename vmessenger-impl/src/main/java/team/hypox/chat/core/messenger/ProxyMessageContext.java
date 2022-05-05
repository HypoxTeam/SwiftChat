package team.hypox.chat.core.messenger;

import team.hypox.chat.core.structure.message.MessageContext;

public interface ProxyMessageContext extends MessageContext {

	String getOriginalServer();

}

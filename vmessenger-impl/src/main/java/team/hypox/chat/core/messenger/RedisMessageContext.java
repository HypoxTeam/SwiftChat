package team.hypox.chat.core.messenger;

import lombok.RequiredArgsConstructor;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;

@RequiredArgsConstructor
public class RedisMessageContext implements ProxyMessageContext {

	private final ChannelMember author;
	private final String originalMessage;
	private final String server;
	private String formattedMessage;

	@Override
	public String message() {
		return originalMessage;
	}

	@Override
	public ChannelMember author() {
		return author;
	}

	@Override
	public String getOriginalServer() {
		return server;
	}

	@Override
	public void formatMessage(String newFormattedMessage) {
		this.formattedMessage = newFormattedMessage;
	}

	@Override
	public String formattedMessage() {
		return formattedMessage == null ? originalMessage : formattedMessage;
	}

	@Override
	public MessageContext clone() {
		RedisMessageContext clone = new RedisMessageContext(author, originalMessage, server);
		clone.formattedMessage = formattedMessage();

		return clone;
	}
}

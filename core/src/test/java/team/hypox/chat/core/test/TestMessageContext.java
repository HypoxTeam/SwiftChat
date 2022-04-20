package team.hypox.chat.core.test;

import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;

public class TestMessageContext implements MessageContext {

	private final ChannelMember author;

	private final String message;
	private String formattedMessage;

	public TestMessageContext(ChannelMember author, String message) {
		this.author = author;
		this.message = message;
	}

	@Override
	public String message() {
		return message;
	}

	@Override
	public ChannelMember author() {
		return author;
	}

	@Override
	public void formatMessage(String newFormattedMessage) {
		this.formattedMessage = newFormattedMessage;
	}

	@Override
	public String formattedMessage() {
		return formattedMessage == null ? message : formattedMessage;
	}

	@Override
	public MessageContext clone() {
		MessageContext clone = new TestMessageContext(author, message);
		clone.formatMessage(formattedMessage);

		return clone;
	}
}

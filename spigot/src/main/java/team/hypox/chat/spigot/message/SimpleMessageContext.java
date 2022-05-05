package team.hypox.chat.spigot.message;

import lombok.Data;
import team.hypox.chat.core.structure.member.ChannelMember;
import team.hypox.chat.core.structure.message.MessageContext;

@Data
public class SimpleMessageContext implements MessageContext {

	private final ChannelMember author;
	private final String originalMessage;
	private String formattedMessage;

	public static MessageContext create(ChannelMember member, String message) {
		return new SimpleMessageContext(member, message);
	}

	@Override
	public String message() {
		return originalMessage;
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
		return formattedMessage == null ? originalMessage : formattedMessage;
	}

	@Override
	public MessageContext clone() {
		SimpleMessageContext clone = new SimpleMessageContext(author, originalMessage);
		clone.formattedMessage = formattedMessage();

		return clone;
	}
}

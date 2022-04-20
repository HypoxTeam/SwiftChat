package team.hypox.chat.core.test;

import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.message.MessageContext;

import java.util.UUID;

public class TestChannelMember implements ChannelMember {

	private final UUID id = UUID.randomUUID();
	private final String name;

	public TestChannelMember(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public UUID id() {
		return id;
	}

	@Override
	public void sendMessage(MessageContext message) {
		System.out.println(message.formattedMessage());
	}

}

package team.hypox.chat.core.message;

import team.hypox.chat.core.member.ChannelMember;

public interface MessageContext {

	MessageContent<?> content();

	ChannelMember author();

	interface MessageContent<T> {
		T get();
	}

}

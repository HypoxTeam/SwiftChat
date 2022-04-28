package team.hypox.chat.core.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import team.hypox.chat.core.channel.Channel;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.util.ChannelMemberList;

public class ChannelTest {

	public static final ChannelMemberList MEMBERS = ChannelMemberList.empty();

	@Test
	public void testChannel() {
		String message = "good morning @Diego and @TestUser!";
		String expected = "TestUser -> good morning -> MENTIONED YOU <- and @TestUser!| sent for: Diego";

		Channel globalChannel = new TestGlobalChannel();
		ChannelMember author = new TestChannelMember("TestUser");
		ChannelMember user2 = new TestChannelMember("TestUser2");
		TestChannelMember diego = new TestChannelMember("Diego");

		MEMBERS.add(author);
		MEMBERS.add(diego);
		MEMBERS.add(user2);

		globalChannel.notifyMessage(new TestMessageContext(author, message));

		Assertions.assertEquals(expected, diego.lastMessage());
	}

}

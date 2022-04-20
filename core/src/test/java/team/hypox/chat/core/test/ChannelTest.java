package team.hypox.chat.core.test;

import org.junit.jupiter.api.Test;
import team.hypox.chat.core.channel.Channel;
import team.hypox.chat.core.member.ChannelMember;
import team.hypox.chat.core.util.ChannelMemberList;

public class ChannelTest {

	public static final ChannelMemberList MEMBERS = ChannelMemberList.empty();

	@Test
	public void testChannel() throws Exception {
		String message = "good morning @Diego !";

		Channel globalChannel = new TestGlobalChannel();
		ChannelMember author = new TestChannelMember("TestUser");

		MEMBERS.add(author);
		MEMBERS.add(new TestChannelMember("Diego"));
		MEMBERS.add(new TestChannelMember("TestUser2"));

		globalChannel.notifyMessage(new TestMessageContext(author, message));
	}

}

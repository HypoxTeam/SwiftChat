package team.hypox.chat.core.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;
import team.hypox.chat.core.structure.member.ChannelMember;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(staticName = "empty")
@AllArgsConstructor(staticName = "from")
public class ChannelMemberList implements List<ChannelMember> {

	@Delegate
	private List<ChannelMember> channelMembers = new ArrayList<>();

}

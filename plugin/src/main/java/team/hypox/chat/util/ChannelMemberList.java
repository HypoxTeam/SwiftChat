package team.hypox.chat.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;
import team.hypox.chat.member.ChannelMember;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ChannelMemberList implements List<ChannelMember> {

	@Delegate
	private List<ChannelMember> channelMembers = new ArrayList<>();

}

package team.hypox.chat.core.member;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChannelMemberPreferences {

	private final List<ChannelMember> ignoredMembers = new ArrayList<>();

	public boolean ignores(ChannelMember member) {
		return ignoredMembers.contains(member);
	}

}

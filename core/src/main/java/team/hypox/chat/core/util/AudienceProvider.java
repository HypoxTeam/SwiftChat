package team.hypox.chat.core.util;

public interface AudienceProvider {

	/**
	 * Invoke a channel member list
	 * @return new member list
	 */
	ChannelMemberList invoke();

}

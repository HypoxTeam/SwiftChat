package team.hypox.chat.core.channel.option;

public interface ChannelOptionContext {

	<T> T as(Class<T> type);

	String json();

}

package team.hypox.chat.core.driver;

import team.hypox.chat.core.structure.channel.Channel;

import java.util.Iterator;
import java.util.concurrent.CompletableFuture;

public interface ChannelDriver {

	CompletableFuture<Iterator<Channel>> asyncIterator();

	CompletableFuture<Void> save(Channel channel);

	CompletableFuture<Channel> find(String channelName);

}

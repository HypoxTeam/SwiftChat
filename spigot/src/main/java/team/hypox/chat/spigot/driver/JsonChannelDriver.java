package team.hypox.chat.spigot.driver;

import com.google.gson.Gson;
import team.hypox.chat.core.configuration.ConfigurationFactory;
import team.hypox.chat.core.driver.ChannelDriver;
import team.hypox.chat.core.structure.channel.Channel;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class JsonChannelDriver implements ChannelDriver {

	private static final String JSON_EXTENSION = ".json";
	private static final Gson SERIALIZER = JsonMapperProvider.GSON;

	private final File folder;

	public JsonChannelDriver(ConfigurationFactory factory) {
		this.folder = factory.createFile("channels");
	}

	@Override
	public CompletableFuture<Iterator<Channel>> asyncIterator() {
		return CompletableFuture.supplyAsync(this::iterateChannels);
	}

	@Override
	public CompletableFuture<Void> save(Channel channel) {
		return CompletableFuture.runAsync(() ->
			serialize(channel)
		);
	}

	@Override
	public CompletableFuture<Channel> find(String channelName) {
		return CompletableFuture.supplyAsync(() ->
			serialize(getFile(channelName))
		);
	}

	private Iterator<Channel> iterateChannels() {
		return getFiles().stream()
				.map(this::serialize)
				.iterator();
	}

	private Channel serialize(File file) {
		try (Reader reader = new FileReader(file)) {
			return SERIALIZER.fromJson(reader, Channel.class);
		} catch (IOException e) {
			throw new RuntimeException("Failed to serialize a " + file.getName() + " file!", e);
		}
	}

	private File serialize(Channel channel) {
		File file = createFile(channel);

		try (Writer writer = new FileWriter(file)) {
			SERIALIZER.toJson(channel, writer);
		} catch (IOException exception) {
			throw new IllegalStateException("Cannot write a file! " + file.getName(), exception);
		}

		return file;
	}

	private File createFile(Channel channel) {
		File file = new File(folder, channel.data().getName() + JSON_EXTENSION);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException exception) {
			throw new IllegalStateException("Cannot create a file! " + file, exception);
		}

		return file;
	}

	private File getFile(String name) {
		return new File(folder, name + JSON_EXTENSION);
	}

	private List<File> getFiles() {
		File[] files = folder.listFiles(
				file -> file.getName().endsWith(JSON_EXTENSION)
		);

		if (files == null) {
			return new ArrayList<>();
		}

		return Arrays.asList(files);
	}
}

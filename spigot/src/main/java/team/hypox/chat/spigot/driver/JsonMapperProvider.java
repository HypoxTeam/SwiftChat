package team.hypox.chat.spigot.driver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import team.hypox.chat.core.channel.ChannelData;
import team.hypox.chat.core.channel.ChannelFactory;
import team.hypox.chat.core.structure.channel.Channel;
import team.hypox.chat.core.structure.channel.ChannelCondition;
import team.hypox.chat.core.structure.channel.ChannelFormatter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonMapperProvider {

	public final static Gson GSON = new GsonBuilder()
			.registerTypeAdapter(JsonMapperProvider.class, (JsonSerializer<JsonMapperProvider>) (src, typeOfSrc, context) -> null)
			.create();

	public static class ChannelSerializer implements JsonSerializer<Channel>, JsonDeserializer<Channel> {

		private static final Gson BLANK_GSON = new Gson();
		private static final Type LIST = new TypeToken<List<String>>() {}.getType();

		private final ChannelFactory channelFactory;

		public ChannelSerializer(ChannelFactory channelFactory) {
			this.channelFactory = channelFactory;
		}

		@Override
		public JsonElement serialize(Channel src, Type typeOfSrc, JsonSerializationContext context) {
			JsonObject object = new JsonObject();
			ChannelData data = src.data();

			object.addProperty("name", data.getName());

			if (data.isTemplated()) {
				object.addProperty("template", data.getTemplate());
			}

			List<String> conditionals = data.getConditionals().stream().map(Class::getName).collect(Collectors.toList());
			List<String> formatters = data.getFormatters().stream().map(Class::getName).collect(Collectors.toList());

			object.addProperty("conditionals", BLANK_GSON.toJson(conditionals, LIST));
			object.addProperty("formatters", BLANK_GSON.toJson(formatters, LIST));

			return object;
		}

		@Override
		public Channel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			JsonObject object = json.getAsJsonObject();
			ChannelData data = ChannelData.with()
					.name(object.get("name").getAsString())
					.audienceType(object.get("audience").getAsString())
					.template(object.get("template").getAsString())
					.conditionals(clazz(ChannelCondition.class, object.get("conditionals").getAsString()))
					.formatters(clazz(ChannelFormatter.class, object.get("formatters").getAsString()))
					.build();

			return channelFactory.from(data);
		}

		@SuppressWarnings("unchecked")
		private <T> List<Class<? extends T>> clazz(Class<T> entity, String json) {
			List<String> query = BLANK_GSON.fromJson(json, LIST);
			List<Class<? extends T>> classes = new ArrayList<>();

			for (String className : query) {
				try {
					Class<?> unknown = Class.forName(className);
					if (entity.isAssignableFrom(unknown)) {
						classes.add((Class<? extends T>) unknown);
					}
				} catch (ClassNotFoundException e) {
					new Exception("Error while deserializing unknown class by " + className).printStackTrace();
				}
			}

			return classes;
		}
	}

}

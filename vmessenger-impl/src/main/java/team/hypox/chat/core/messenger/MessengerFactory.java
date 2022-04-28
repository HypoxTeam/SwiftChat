package team.hypox.chat.core.messenger;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import net.ibxnjadev.vmessenger.redis.RedisMessenger;
import net.ibxnjadev.vmessenger.universal.Messenger;
import net.ibxnjadev.vmessenger.universal.serialize.ObjectSerialize;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
public class MessengerFactory {

	private final JedisPool pool;
	private final ObjectMapper mapper;

	private final Map<Class<?>, ObjectSerialize> serializers = new HashMap<>();

	public Messenger newRedisMessenger(String name, ObjectSerialize serialize) {
		requireNonNull(name, "Messenger name cant be null"	);
		requireNonNull(serialize, "Object serializer not found in serializer map or is null");

		return new RedisMessenger(name, pool, pool.getResource(), serialize, mapper);
	}

	public Messenger newRedisMessenger(String name, Class<?> clazz) {
		return newRedisMessenger(name, serializers.get(clazz));
	}

	public void registerSerializer(ObjectSerialize serializer, Class<?> clazz) {
		serializers.put(clazz, serializer);
	}

}

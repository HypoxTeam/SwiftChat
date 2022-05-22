package team.hypox.chat.spigot.bukkit;

import org.bukkit.Bukkit;

import java.util.UUID;
import java.util.function.Function;

public class Processors {

	public static Function<Object, Object> ANYTHING = unused -> unused;
	public static Function<Object, Object> WORLD = argument -> Bukkit.getWorld((String) argument);
	public static Function<Object, Object> ID = argument -> UUID.fromString((String) argument);

}

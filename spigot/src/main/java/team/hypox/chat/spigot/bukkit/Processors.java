package team.hypox.chat.spigot.bukkit;

import org.bukkit.Bukkit;

import java.util.function.Function;

public class Processors {

	public static Function<Object, Object> ANYTHING = unused -> unused;
	public static Function<Object, Object> WORLD = argument -> Bukkit.getWorld((String) argument);

}

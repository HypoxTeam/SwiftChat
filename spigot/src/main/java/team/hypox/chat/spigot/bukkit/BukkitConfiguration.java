package team.hypox.chat.spigot.bukkit;

import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import team.hypox.chat.core.commons.Condition;
import team.hypox.chat.core.configuration.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public final class BukkitConfiguration extends YamlConfiguration implements Configuration {

	private final Plugin plugin;
	private final String fileName;
	private final File file;

	public BukkitConfiguration(Plugin plugin, File file, String fileName) {
		Condition.notNull(plugin, "Plugin cannot be null");
		Condition.notNull(fileName, "File name cannot be null");
		Condition.notNull(file, "Parent file cannot be null");

		this.plugin = plugin;
		this.fileName = fileName;
		this.file = new File(file, fileName);

		saveDef();
		reloadFile();
	}

	public BukkitConfiguration(Plugin plugin, String fileName) {
		this(plugin, plugin.getDataFolder(), fileName);
	}

	@Override
	public String getString(String path) {
		return formatString(super.getString(path, path));
	}

	@Override
	public float getFloat(String path) {
		Object val = get(path);
		return (val instanceof Float) ? (Float) val : 0;
	}

	@Override
	public List<String> getStringList(String path) {
		return super.getStringList(path).stream()
				.map(this::formatString)
				.collect(Collectors.toList());
	}

	public void reloadFile() {
		try {
			this.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	private void saveDef() {
		if (!file.exists()) {
			plugin.saveResource(fileName, false);
		}
	}

	public void save() {
		try {
			save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String formatString(final String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}

}

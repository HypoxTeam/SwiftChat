package team.hypox.chat.spigot.settings.censure;

import team.hypox.chat.core.configuration.Configuration;
import team.hypox.chat.core.configuration.ConfigurationFactory;

import java.util.List;

public class CensureSettings {

	private final Configuration config;

	public CensureSettings(ConfigurationFactory factory) {
		this.config = factory.create("censure-settings.yml");
	}

	public List<String> censuredWords() {
		return config.getStringList("blacklist");
	}

	public String replaceWord() {
		return config.getString("replace");
	}

}

package team.hypox.chat.core.configuration;

import java.io.File;

public interface ConfigurationFactory {

	Configuration create(String name);

	File createFile(String name);

}

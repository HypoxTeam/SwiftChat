package team.hypox.chat.core.configuration;

import java.util.List;

public interface Configuration {

	String getString(String node);

	int getInt(String node);

	float getFloat(String node);

	List<String> getStringList(String node);

}

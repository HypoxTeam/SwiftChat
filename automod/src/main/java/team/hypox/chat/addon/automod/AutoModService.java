package team.hypox.chat.addon.automod;

import com.ghawk1ns.perspective.PerspectiveAPI;
import com.ghawk1ns.perspective.PerspectiveAPIBuilder;
import com.ghawk1ns.perspective.model.Attribute;
import com.ghawk1ns.perspective.request.AnalyzeCommentRequest;
import lombok.SneakyThrows;
import team.hypox.chat.core.configuration.Configuration;
import team.hypox.chat.core.configuration.ConfigurationFactory;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AutoModService {

	private final Deque<String> conversationContext = new LinkedList<>();
	private final Map<String, Float> toxicityCache = new HashMap<>();

	private final PerspectiveAPI api;
	private final Configuration config;

	public AutoModService(ConfigurationFactory factory) {
		this.config = factory.create("automod.yml");

		this.api = new PerspectiveAPIBuilder()
				.setApiKey(config.getString("api-key"))
				.build();
	}

	public boolean isToxic(String message) {
		float toxicity = computeToxicity(message);

		return toxicity >= config.getFloat("max-toxicity");
	}

	@SneakyThrows
	public float computeToxicity(String message) {
		Float toxicity = toxicityCache.get(message);

		if (toxicity == null) {
			toxicity = analyze()
					.setComment(message)
					.postAsync()
					.get(config.getInt("api-timeout"), TimeUnit.SECONDS)
					.getAttributeSummaryScore(Attribute.TOXICITY);

			toxicityCache.put(message, toxicity);
		}

		return toxicity;
	}

	public void addContext(String message) {
		if (conversationContext.size() >= config.getInt("context-message")) {
			conversationContext.pollFirst();
		}

		conversationContext.offerLast(message);
	}

	private AnalyzeCommentRequest analyze() {
		AnalyzeCommentRequest request = api.analyze();

		for (String lang : config.getStringList("languages")) {
			request.addLanguage(lang);
		}

		for (String context : conversationContext) {
			request.addContext(context);
		}

		return request.addAttribute(Attribute.ofType(Attribute.TOXICITY));
	}

}

package dev.alaugks.spring.messagesource.json.catalog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.alaugks.spring.messagesource.catalog.catalog.AbstractCatalog;
import io.github.alaugks.spring.messagesource.catalog.records.TransUnit;
import io.github.alaugks.spring.messagesource.catalog.records.TransUnitInterface;
import io.github.alaugks.spring.messagesource.catalog.records.TranslationFile;
import io.github.alaugks.spring.messagesource.catalog.ressources.ResourcesLoader;

import org.springframework.stereotype.Component;

@Component
public class JsonCatalog extends AbstractCatalog {

	private final List<TransUnitInterface> transUnits = new ArrayList<>();

	@Override
	public List<TransUnitInterface> getTransUnits() {
		return this.transUnits;
	}

	@Override
	public void build() {
		ResourcesLoader resourcesLoader = new ResourcesLoader(
				Locale.forLanguageTag("en"),
				Set.of("messages/*"),
				List.of("json")
		);

		try {
			ObjectMapper mapper = new ObjectMapper();

			for (TranslationFile file : resourcesLoader.getTranslationFiles()) {

				HashMap<String, Object> myObjects = mapper.readValue(
						new String(file.inputStream().readAllBytes()),
						new TypeReference<>() {
						}
				);

				for (Map.Entry<String, Object> item : myObjects.entrySet()) {
					this.transUnits.add(new TransUnit(
							file.locale(),
							item.getKey(),
							item.getValue().toString(),
							file.domain()
					));
				}
			}
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}

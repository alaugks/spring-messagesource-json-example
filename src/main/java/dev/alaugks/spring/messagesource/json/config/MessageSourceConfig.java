package dev.alaugks.spring.messagesource.json.config;

import java.util.Locale;

import dev.alaugks.spring.messagesource.json.catalog.JsonCatalog;
import io.github.alaugks.spring.messagesource.catalog.CatalogMessageSourceBuilder;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageSourceConfig {

	@Bean
	public MessageSource messageSource() {
		return CatalogMessageSourceBuilder
				.builder(new JsonCatalog(), Locale.forLanguageTag("en"))
				.build();
	}

}

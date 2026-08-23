package dev.alaugks.spring.messagesource.json.config;

import io.github.alaugks.spring.messagesource.json.JsonResourceMessageSource;
import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageSourceConfig {

	@Bean
	public MessageSource messageSource() {
		return JsonResourceMessageSource.builder(
			Locale.forLanguageTag("en"),
			"messages/*"
		).enableICU4j().build();
	}

}

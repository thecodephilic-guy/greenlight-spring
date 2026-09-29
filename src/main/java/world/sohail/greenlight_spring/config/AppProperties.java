package world.sohail.greenlight_spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record AppProperties (
	String version,
	String env
){}

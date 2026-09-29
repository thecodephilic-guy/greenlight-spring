package world.sohail.greenlight_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class GreenlightSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenlightSpringApplication.class, args);
	}

}

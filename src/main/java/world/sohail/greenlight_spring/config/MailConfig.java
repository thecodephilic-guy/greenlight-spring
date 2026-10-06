package world.sohail.greenlight_spring.config;

import com.resend.Resend;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Configuration
public class MailConfig {

    @Bean
    @ConditionalOnProperty(name = "RESEND_API_KEY")
    public Resend resend(@Value("${RESEND_API_KEY:}") String apiKey) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("RESEND_API_KEY must be provided in .env");
        }
        return new Resend(apiKey);
    }
}

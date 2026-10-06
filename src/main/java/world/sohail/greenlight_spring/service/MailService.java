package world.sohail.greenlight_spring.service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import world.sohail.greenlight_spring.config.AppProperties;

@Service
public class MailService {

    private static final Logger log = LoggerFactory.getLogger(MailService.class);

    private final ObjectProvider<Resend> resendProvider;
    private final AppProperties appProperties;

    public MailService(ObjectProvider<Resend> resendProvider, AppProperties appProperties) {
        this.resendProvider = resendProvider;
        this.appProperties = appProperties;
    }

    public void sendWelcomeEmail(String recipientEmail, String recipientName, String activationToken) {
        try {
            Resend resend = resendProvider.getIfAvailable();
            if (resend == null) {
                throw new IllegalStateException("Email service is unavailable: RESEND_API_KEY is not configured");
            }
            CreateEmailOptions params = CreateEmailOptions.builder()
                    .from(appProperties.mailer().sender())
                    .to(recipientEmail)
                    .subject("Welcome to Greenlight!")
                    .html("<p>Hi " + recipientName + ",</p><p>Please activate your account with token: <strong>" + activationToken + "</strong></p>")
                    .build();

            resend.emails().send(params);
            log.info("Welcome email sent to {}", recipientEmail);
        } catch (ResendException e) {
            log.error("Failed to send welcome email via Resend", e);
        }
    }
}

package world.sohail.greenlight_spring.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.sohail.greenlight_spring.config.AppProperties;
import world.sohail.greenlight_spring.system.dto.HealthcheckResponse;

@RestController
@RequestMapping("/v1")
public class HealthController {
    private final AppProperties appProperties;

    //Constructor Injection: HealthController's Bean is wired to appProperties as it depends on it:
    public HealthController(AppProperties appProperties){
        this.appProperties = appProperties;
    }

    @GetMapping("/healthcheck")
    public HealthcheckResponse healthcheck() {
        return new HealthcheckResponse(
                "available",
                appProperties.env(),
                appProperties.version()
        );
    }
}

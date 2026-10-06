package world.sohail.greenlight_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import world.sohail.greenlight_spring.config.AppProperties;
import world.sohail.greenlight_spring.dto.HealthcheckResponse;

@RestController
@RequestMapping("/v1")
public class HealthController {
    private final AppProperties appProperties;

    //Constructor Injection: HealthController's Bean is wired to appProperties as it depends on it:
    public HealthController(AppProperties appProperties){
        this.appProperties = appProperties;
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<HealthcheckResponse> healthcheck() {
        HealthcheckResponse response = new HealthcheckResponse(
                "available",
                appProperties.env(),
                appProperties.version()
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}

package world.sohail.greenlight_spring.system.dto;

public record HealthcheckResponse(
        String status,
        String environment,
        String version
){}

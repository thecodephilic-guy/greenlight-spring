package world.sohail.greenlight_spring.dto;

public record HealthcheckResponse(
        String status,
        String environment,
        String version
){}

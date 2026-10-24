package world.sohail.greenlight_spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
        String status,
        String message,
        T data,
        Object metadata
){
    public ApiResponse(String status, String message, T data) {
        this(status, message, data, null);
    }

    //success without metadata
    public static <T> ApiResponse<T> success(String message, T data){
        return new ApiResponse<>("success", message, data, null);
    }

    //success with metadata
    public static <T> ApiResponse<T> success(String message, T data, Object metadata){
        return new ApiResponse<>("success", message, data, metadata);
    }

    //error response:
    public static <T> ApiResponse<T> error(String message){
        return new ApiResponse<>("error", message, null, null);
    }
}

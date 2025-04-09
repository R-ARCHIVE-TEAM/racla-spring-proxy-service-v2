package app.racla.raclaspringproxyservicev2.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
  private boolean success;
  private String message;
  private T data;

  public static <T> ApiResponse<T> success(T data) {
    return ApiResponse.<T>builder().success(true).message("성공").data(data).build();
  }

  public static <T> ApiResponse<T> success(String message, T data) {
    return ApiResponse.<T>builder().success(true).message(message).data(data).build();
  }

  public static <T> ApiResponse<T> error(String message) {
    return ApiResponse.<T>builder().success(false).message(message).build();
  }

  public static <T> ApiResponse<T> error(String message, T data) {
    return ApiResponse.<T>builder().success(false).message(message).data(data).build();
  }

  public ApiResponse<T> data(T data) {
    this.data = data;
    return this;
  }
}

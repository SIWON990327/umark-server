package umc.project.umark.global.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.project.umark.global.exception.GlobalErrorCode;

@Getter
@AllArgsConstructor
@JsonPropertyOrder( {"isSuccess", "code", "message", "result"} )
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private Boolean isSuccess;
    private String code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    // 성공한 경우 응답 생성

    public static <T> ApiResponse<T> onSuccess(T data){
        return new ApiResponse<>(true, "200" , "요청에 성공하였습니다.", data);
    }

    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(GlobalErrorCode code,  T data){
        return new ApiResponse<>(false, String.valueOf(code.getHttpStatus().value()), code.getMessage(), data);
    }

}

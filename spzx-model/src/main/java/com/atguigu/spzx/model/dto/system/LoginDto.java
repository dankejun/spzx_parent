package com.atguigu.spzx.model.dto.system;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(description = "用户登录请求参数")
public class LoginDto {

    @Schema(description = "用户名")
    @NotEmpty(message = "用户名不能为空")
    private String userName ;

    @Schema(description = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password ;

    @Schema(description = "提交验证码")
    @NotEmpty(message = "验证码不能为空")
    private String captcha ;

    @Schema(description = "验证码key")
    @NotEmpty(message = "验证码key不能为空")
    private String codeKey ;

}

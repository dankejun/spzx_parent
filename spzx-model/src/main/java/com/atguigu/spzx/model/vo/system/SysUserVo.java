package com.atguigu.spzx.model.vo.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * Time: 2025/6/24
 * Author: Dankejun
 * Description:
 */
@Data
@Schema(description = "系统用户实体类Vo")
public class SysUserVo {
    @Schema(description = "昵称")
    private String name;

    @Schema(description = "图像")
    private String avatar;

    @Schema(description = "描述")
    private String introduction;

    @Schema(description = "角色")
    private List<String> roles;
}

package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.vo.system.LoginVo;

/**
 * Time: 2025/6/23
 * Author: Dankejun
 * Description:
 */
public interface SysUserService {
    LoginVo login(LoginDto loginDto);
}

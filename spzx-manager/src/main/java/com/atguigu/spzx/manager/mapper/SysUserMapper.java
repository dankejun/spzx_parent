package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Time: 2025/6/23
 * Author: Dankejun
 * Description:
 */
@Mapper
public interface SysUserMapper {
    SysUser selectByUserName(String userName);
}

package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.system.SysOperLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * Time: 2025/8/15
 * Author: Dankejun
 * Description:
 */
@Mapper
public interface SysOperLogMapper {
    void insert(SysOperLog sysOperLog);
}

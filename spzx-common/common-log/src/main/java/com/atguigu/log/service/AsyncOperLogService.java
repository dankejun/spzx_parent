package com.atguigu.log.service;

import com.atguigu.spzx.model.entity.system.SysOperLog;

/**
 * Time: 2025/8/15
 * Author: Dankejun
 * Description:
 */
public interface AsyncOperLogService {
    void saveSysOperLog(SysOperLog sysOperLog);
}

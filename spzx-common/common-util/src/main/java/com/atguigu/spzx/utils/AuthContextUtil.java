package com.atguigu.spzx.utils;

import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.system.SysUserVo;

/**
 * Time: 2025/6/25
 * Author: Dankejun
 * Description:
 */
public class AuthContextUtil {

    //创建threadlocal对象
    private static final ThreadLocal<SysUserVo> THREAD_LOCAL = new ThreadLocal<>();

    //添加数据
    public static void set(SysUserVo sysUser) {
        THREAD_LOCAL.set(sysUser);
    }

    //获取数据
    public static SysUserVo get() {
        return THREAD_LOCAL.get();
    }

    //删除数据
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}

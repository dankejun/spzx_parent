package com.atguigu.spzx.manager.service;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.atguigu.spzx.common.exception.GuiguException;
import com.atguigu.spzx.manager.mapper.SysUserMapper;
import com.atguigu.spzx.model.dto.system.LoginDto;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.model.vo.system.LoginVo;
import com.atguigu.spzx.model.vo.system.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Time: 2025/6/23
 * Author: Dankejun
 * Description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public LoginVo login(LoginDto loginDto) {
        //获取输入验证码和redis中的key名称
        String captcha = loginDto.getCaptcha();

        //根据获取的redis里的key，查询redis中存储的验证码
        String codeKey = loginDto.getCodeKey();
        String redisCode = redisTemplate.opsForValue().get("user:validate" + codeKey);

        //比较验证码是否正确
        if (StrUtil.isEmpty(redisCode) || !StrUtil.equalsIgnoreCase(redisCode, captcha)) {
            //不一致提示校验失败
            throw new GuiguException(ResultCodeEnum.VALIDATECODE_ERROR);
        }

        //一致删除redis里的验证码
        redisTemplate.delete("user:validate" + codeKey);

        //1. 获取提交用户名
        String userName = loginDto.getUserName();

        //2. 根据用户名查询数据库
        SysUser sysUser = sysUserMapper.selectByUserName(userName);

        //3. 如果用户名查不到，用户不存在，返回错误信息
        if (sysUser == null) {
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);
        }

        //4. 如果用户名查询到用户，用户存在
        //5. 获取输入的密码，比较输入的密码和数据库密码是否一致
        String database_password = sysUser.getPassword();
        String input_password = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());

        //6. 如果密码一致，登录成功，如果密码不一致登录失败
        if (!input_password.equals(database_password)) {
            throw new GuiguException(ResultCodeEnum.LOGIN_ERROR);
        }

        //7. 登录成果，生成用户唯一标识token
        String token = UUID.randomUUID().toString().replaceAll("-", "");

        //8. 把登录成果用户信息放到redis中
        redisTemplate.opsForValue().set("user:login" + token, JSON.toJSONString(sysUser), 7, TimeUnit.DAYS);

        //9. 返回VO对象
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);

        return loginVo;
    }

    @Override
    public SysUserVo getUserInfo(String token) {
        SysUserVo sysUserVo = new SysUserVo();
        String userJson = redisTemplate.opsForValue().get("user:login" + token);
        SysUser sysUser = JSON.parseObject(userJson, SysUser.class);
        if (sysUser != null) {
            sysUserVo.setAvatar(sysUser.getAvatar());
            sysUserVo.setName(sysUser.getName());
            sysUserVo.setIntroduction(sysUser.getDescription());
            sysUserVo.setRoles(Collections.singletonList("admin"));
        }
        return sysUserVo;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete("user:login" + token);
    }
}

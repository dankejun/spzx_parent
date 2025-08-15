package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.order.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;

/**
 * Time: 2025/8/15
 * Author: Dankejun
 * Description:
 */
@Mapper
public interface OrderInfoMapper {
    OrderStatistics selectOrderStatistics(String createTime);
}

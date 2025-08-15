package com.atguigu.spzx.manager.service;

import com.atguigu.spzx.model.dto.order.OrderStatisticsDto;
import com.atguigu.spzx.model.vo.order.OrderStatisticsVo;

/**
 * Time: 2025/8/15
 * Author: Dankejun
 * Description:
 */
public interface OrderInfoService {
    OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto);
}

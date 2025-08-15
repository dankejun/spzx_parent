package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.base.ProductUnit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Time: 2025/8/5
 * Author: Dankejun
 * Description:
 */
@Mapper
public interface ProductUnitMapper {
    List<ProductUnit> findAll();
}

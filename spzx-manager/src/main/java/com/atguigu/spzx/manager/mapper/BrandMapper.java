package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Time: 2025/7/31
 * Author: Dankejun
 * Description:
 */
@Mapper
public interface BrandMapper {
    List<Brand> findByPage();

    void save(Brand brand);

    void updateById(Brand brand);

    void deleteById(Long id);

    List<Brand> findAll();
}

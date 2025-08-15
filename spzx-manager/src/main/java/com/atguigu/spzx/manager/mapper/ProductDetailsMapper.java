package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * Time: 2025/8/5
 * Author: Dankejun
 * Description:
 */
@Mapper
public interface ProductDetailsMapper {
    ProductDetails selectByProductId(Long id);

    void save(ProductDetails productDetails);

    void updateById(ProductDetails productDetails);

    void deleteByProductId(Long id);
}

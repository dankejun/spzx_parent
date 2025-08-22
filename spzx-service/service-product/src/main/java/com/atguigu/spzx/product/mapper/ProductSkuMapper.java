package com.atguigu.spzx.product.mapper;

import com.atguigu.spzx.model.entity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Time: 2025/8/19
 * Author: Dankejun
 * Description:
 */
@Mapper
public interface ProductSkuMapper {
    List<ProductSku> findProductSkuBySale();
}

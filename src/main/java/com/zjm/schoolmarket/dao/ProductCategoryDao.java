package com.zjm.schoolmarket.dao;

import com.zjm.schoolmarket.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通过shopId查询店铺类别
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(Long shopId); //根据shopId返回此店铺下的所有商品类别

    /**
     * 批量新增商品类别
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 删除指定商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return effectedNum
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);
}

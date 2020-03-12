package com.zjm.schoolmarket.service;

import com.zjm.schoolmarket.dto.ProductCategoryExecution;
import com.zjm.schoolmarket.entity.ProductCategory;
import com.zjm.schoolmarket.exception.ProductCategoryOperationException;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 查询指定某个店铺下的所有商品类别信息
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(long shopId);

    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;

    ProductCategoryExecution deleteProductCategory(Long productCategoryId, Long shopId);
}

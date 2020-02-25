package com.zjm.schoolmarket.service;

import com.zjm.schoolmarket.dto.ShopExecution;
import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.exception.ShopOperationException;

import java.io.File;
import java.io.InputStream;

public interface ShopService {

    /***
     * 通过Id获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(Long shopId);
    /***
     * 更新店铺信息，包括对图片的处理
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException;
    /***
     * 注册店铺
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException;
}

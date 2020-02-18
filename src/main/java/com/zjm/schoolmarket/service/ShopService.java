package com.zjm.schoolmarket.service;

import com.zjm.schoolmarket.dto.ShopExecution;
import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.exception.ShopOperationException;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopOperationException;
}

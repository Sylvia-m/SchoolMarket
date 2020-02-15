package com.zjm.schoolmarket.service;

import com.zjm.schoolmarket.dto.ShopExecution;
import com.zjm.schoolmarket.entity.Shop;

import java.io.File;

public interface ShopService {
    ShopExecution addShop(Shop shop, File shopImg);
}

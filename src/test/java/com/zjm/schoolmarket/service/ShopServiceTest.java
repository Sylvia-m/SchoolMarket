package com.zjm.schoolmarket.service;

import com.zjm.schoolmarket.BaseTest;
import com.zjm.schoolmarket.dto.ShopExecution;
import com.zjm.schoolmarket.entity.Area;
import com.zjm.schoolmarket.entity.PersonInfo;
import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.entity.ShopCategory;
import com.zjm.schoolmarket.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired //告诉Spring初始化ShopServiceTest时将shopService实现类动态注入到这个接口里面
    private ShopService shopService;

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("七里香");
        shop.setShopDesc("一家很好喝的奶茶店");
        shop.setShopAddr("北门美食城");
        shop.setPhone("13359131857");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("D:/allkinds/img/bawei.jpg");
        ShopExecution se = shopService.addShop(shop,shopImg);
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}

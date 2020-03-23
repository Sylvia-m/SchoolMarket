package com.zjm.schoolmarket.service;

import com.zjm.schoolmarket.BaseTest;
import com.zjm.schoolmarket.dto.ImageHolder;
import com.zjm.schoolmarket.dto.ShopExecution;
import com.zjm.schoolmarket.entity.Area;
import com.zjm.schoolmarket.entity.PersonInfo;
import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.entity.ShopCategory;
import com.zjm.schoolmarket.enums.ShopStateEnum;
import com.zjm.schoolmarket.exceptions.ShopOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired //告诉Spring初始化ShopServiceTest时将shopService实现类动态注入到这个接口里面
    private ShopService shopService;

    @Test
    public void testQueryShopList(){
        Shop shopCondition = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(3L);
        shopCondition.setShopCategory(sc);
        ShopExecution se = shopService.getShopList(shopCondition,1,3);
        System.out.println("店铺列表数为:" + se.getShopList().size());
        System.out.println("店铺总数："+se.getCount());
    }
    @Test
    @Ignore
    public void testModifyShop() throws ShopOperationException,FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("哈哈喜茶");
        File shopImg = new File("D:/allkinds/img/lufei.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder("lufei.jpg",is);
        ShopExecution shopExecution = shopService.modifyShop(shop,imageHolder);
        System.out.println("新图片的地址为："+shopExecution.getShop().getShopImg());
    }

    @Test
    @Ignore
    public void testInsertShop() throws FileNotFoundException {
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
        shop.setShopName("华莱士");
        shop.setShopDesc("学馨苑西侧");
        shop.setShopAddr("学馨苑");
        shop.setPhone("13359131857");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("D:/allkinds/img/bawei.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder imageHolder = new ImageHolder(shopImg.getName(),is);
        ShopExecution se = shopService.addShop(shop,imageHolder);
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}

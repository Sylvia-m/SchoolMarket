package com.zjm.schoolmarket.service.impl;

import com.zjm.schoolmarket.dao.ShopDao;
import com.zjm.schoolmarket.dto.ShopExecution;
import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.enums.ShopStateEnum;
import com.zjm.schoolmarket.exception.ShopOperationException;
import com.zjm.schoolmarket.service.ShopService;
import com.zjm.schoolmarket.util.ImageUtil;
import com.zjm.schoolmarket.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

@Service //定义ShopServiceImpl是要通过Spring来管理的
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInPutStream,String fileName) throws ShopOperationException {
        //首先检查传入的参数是否合法
        //空值判断
        if (shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        //给店铺信息附初始值
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum<=0){
                throw new ShopOperationException("店铺创建失败");
            }else {
                if (shopImgInPutStream !=null){
                    //存储图片
                    try {
                        addShopImg(shop, shopImgInPutStream,fileName);
                    }catch (Exception e){
                        e.printStackTrace();
                        throw new ShopOperationException("addShopImg error:"+e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum<=0){
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInPutStream,String fileName) {
        //获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInPutStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}

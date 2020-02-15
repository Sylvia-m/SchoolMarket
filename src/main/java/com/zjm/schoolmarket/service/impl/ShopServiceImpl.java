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
import java.util.Date;

@Service //����ShopServiceImpl��Ҫͨ��Spring�������
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, File shopImg) {
        //���ȼ�鴫��Ĳ����Ƿ�Ϸ�
        //��ֵ�ж�
        if (shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        //��������Ϣ����ʼֵ
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //��ӵ�����Ϣ
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum<=0){
                throw new ShopOperationException("���̴���ʧ��");
            }else {
                if (shopImg!=null){
                    //�洢ͼƬ
                    try {
                        addShopImg(shop,shopImg);
                    }catch (Exception e){
                        e.printStackTrace();
                        throw new ShopOperationException("addShopImg error:"+e.getMessage());
                    }
                    //���µ��̵�ͼƬ��ַ
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum<=0){
                        throw new ShopOperationException("����ͼƬ��ַʧ��");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, File shopImg) {
        //��ȡshopͼƬĿ¼�����ֵ·��
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImg,dest);
        shop.setShopImg(shopImgAddr);
    }
}

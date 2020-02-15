package com.zjm.schoolmarket.dto;

import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.enums.ShopStateEnum;

import java.util.List;

public class ShopExecution {
    //���״̬
    private int state;

    //״̬��ʶ
    private String stateInfo;

    //��������
    private int count;

    //������shop��������ɾ�Ĳ��ʱ���õ���
    private Shop shop;

    //shop�б���ѯ�����б��ʱ���õ���
    private List<Shop> shopList;

    public ShopExecution() {

    }

    //���̲���ʧ��ʱʹ�õĹ�������ֻ���ص���״̬
    public ShopExecution(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    //���̲����ɹ�ʱʹ�õĹ��������ɷ���shop����
    public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    //���̲����ɹ�ʱʹ�õĹ��������ɷ���shop�б�
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }
}
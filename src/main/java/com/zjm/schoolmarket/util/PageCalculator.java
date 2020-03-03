package com.zjm.schoolmarket.util;

/**
 * 此工具类作用：为什么在DAO层getShopList方法的第二个参数是rowIndex，而在Service层中第二个参数是pageIndex？
 *              因为前端只认页数，DAO层只认行数，此工具类做转换作用
 */
public class PageCalculator {
    public static int calculateRowIndex(int pageIndex, int pageSize){
        return (pageIndex > 0) ? (pageIndex -1) * pageSize : 0;
    }
}

package com.zjm.schoolmarket.util;

/*
提供两类路径：1.依据执行环境的不同提供根路径（项目图片所需要存放的路径）
 */
public class PathUtil {
    private static String separator = System.getProperty("file.separator"); //获取系统的执行属性
    public static String getImgBasePath(){
        String os = System.getProperty("os.name"); //根据不同的操作系统选择不同的根目录
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath="D:/allkinds";
        }else{
            basePath="/home/zjm/images";
        }
        basePath =  basePath.replace("/", separator);
        return basePath;
    }

    //相对子路径  获取店铺图片的存储路径
    public static String getShopImagePath(long shopId){
        String imagePath = "/upload/item/shop"+shopId+"/";
        return imagePath.replace("/",separator); //返回项目图片的子路径
    }
}

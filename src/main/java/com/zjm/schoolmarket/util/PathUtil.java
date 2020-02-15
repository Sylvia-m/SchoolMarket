package com.zjm.schoolmarket.util;

/*
�ṩ����·����1.����ִ�л����Ĳ�ͬ�ṩ��·������ĿͼƬ����Ҫ��ŵ�·����
 */
public class PathUtil {
    private static String separator = System.getProperty("file.separator"); //��ȡϵͳ��ִ������
    public static String getImgBasePath(){
        String os = System.getProperty("os.name"); //���ݲ�ͬ�Ĳ���ϵͳѡ��ͬ�ĸ�Ŀ¼
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath="D:/allkinds";
        }else{
            basePath="/home/zjm/images";
        }
        basePath =  basePath.replace("/", separator);
        return basePath;
    }

    //�����·��  ��ȡ����ͼƬ�Ĵ洢·��
    public static String getShopImagePath(long shopId){
        String imagePath = "/upload/item/shop"+shopId+"/";
        return imagePath.replace("/",separator); //������ĿͼƬ����·��
    }
}

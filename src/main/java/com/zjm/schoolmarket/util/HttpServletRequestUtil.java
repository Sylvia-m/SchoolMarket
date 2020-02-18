package com.zjm.schoolmarket.util;

import javax.servlet.http.HttpServletRequest;

//负责处理HttpServletRequest参数
public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request,String key){
        try {
            return Integer.decode(request.getParameter(key)); //将返回的字符串对象转换成整型
        }catch (Exception e){
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request,String key) {
        try {
            return Long.valueOf(request.getParameter(key)); //将返回的字符串对象转换成长整型
        } catch (Exception e) {
            return -1;
        }
    }

    public static Double getDouble(HttpServletRequest request,String key) {
        try {
            return Double.valueOf(request.getParameter(key)); //将返回的字符串对象转换成Double型
        } catch (Exception e) {
            return -1d;
        }
    }

    public static boolean getBoolean(HttpServletRequest request,String key) {
        try {
            return Boolean.valueOf(request.getParameter(key)); //将返回的字符串对象转换成布尔型
        } catch (Exception e) {
            return false;
        }
    }

    public static String getString(HttpServletRequest request,String key){
        try {
            String result = request.getParameter(key);
            if (result!=null){
                result = result.trim();
            }
            if ("".equals(result)){
                result=null;
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }

}

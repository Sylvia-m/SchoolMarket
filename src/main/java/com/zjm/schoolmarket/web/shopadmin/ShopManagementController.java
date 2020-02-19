package com.zjm.schoolmarket.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjm.schoolmarket.dto.ShopExecution;
import com.zjm.schoolmarket.entity.Area;
import com.zjm.schoolmarket.entity.PersonInfo;
import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.entity.ShopCategory;
import com.zjm.schoolmarket.enums.ShopStateEnum;
import com.zjm.schoolmarket.exception.ShopOperationException;
import com.zjm.schoolmarket.service.AreaService;
import com.zjm.schoolmarket.service.ShopCategoryService;
import com.zjm.schoolmarket.service.ShopService;
import com.zjm.schoolmarket.util.HttpServletRequestUtil;
import com.zjm.schoolmarket.util.ImageUtil;
import com.zjm.schoolmarket.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getshopinitinfo",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getShopInitInfo(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
        List<Area> areaList = new ArrayList<Area>();
        try {
            shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList = areaService.getAreaList();
            modelMap.put("shopCategoryList",shopCategoryList);
            modelMap.put("areaList",areaList);
            modelMap.put("success",true);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> registerShop(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object>(); //定义一个返回值
        //1.接收并转化相应的参数，包括店铺信息以及图片信息
        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr,Shop.class); //将接受的信息转换成shop实体类
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }

        /**
         * 为什么Service层不直接使用CommonsMultipartFile这个方法？
         * 因为在Service层的UnitTest中CommonsMultipartFile是很难造出来的，会带来编写unitTest的成本，因此改造使用InPutStream
         */
        CommonsMultipartFile shopImg = null; //接受图片信息
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); //文件上传解析器解析request里的信息
        if (commonsMultipartResolver.isMultipart(request)){ //判断request中是否有上传的文件流
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }
        //2.注册店铺
        if (shop!=null&&shopImg!=null){
            PersonInfo owner = new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);
            ShopExecution se = null;
            try {
                se = shopService.addShop(shop,shopImg.getInputStream(),shopImg.getOriginalFilename());
                if (se.getState()== ShopStateEnum.CHECK.getState()){
                    modelMap.put("success",true);

                }else {
                    modelMap.put("success",false);
                    modelMap.put("success",se.getStateInfo());
                }
            } catch (ShopOperationException e) {
                modelMap.put("success",false);
                modelMap.put("success",e.getMessage());
            }catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("success",e.getMessage());
            }

            return modelMap;         //3.返回结果
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入店铺信息");
            return modelMap;
        }

    }

//    private static void inPutStreamToFile(InputStream ins,File file){
//        FileOutputStream os = null;
//        try {
//            os = new FileOutputStream(file);
//            int bytesRead = 0;
//            byte[] buffer = new byte[1024];
//            while ((bytesRead = ins.read(buffer))!=-1){
//                os.write(buffer,0,bytesRead);
//            }
//        }catch (Exception e){
//            throw new RuntimeException("调用inputStreamToFile时产生异常"+e.getMessage());
//        }finally {
//            try {
//                if (os!=null){
//                    os.close();
//                }
//                if (ins!=null){
//                    ins.close();
//                }
//            }catch (Exception e){
//                throw new RuntimeException("inputStreamToFile关闭io产生异常"+e.getMessage());
//            }
//        }
//    }
}

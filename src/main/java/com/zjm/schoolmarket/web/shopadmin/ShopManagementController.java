package com.zjm.schoolmarket.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjm.schoolmarket.dto.ShopExecution;
import com.zjm.schoolmarket.entity.PersonInfo;
import com.zjm.schoolmarket.entity.Shop;
import com.zjm.schoolmarket.enums.ShopStateEnum;
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
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @RequestMapping(value = "/registershop",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> registerShop(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object>(); //����һ������ֵ
        //1.���ղ�ת����Ӧ�Ĳ���������������Ϣ�Լ�ͼƬ��Ϣ
        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr,Shop.class); //�����ܵ���Ϣת����shopʵ����
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }

        CommonsMultipartFile shopImg = null; //����ͼƬ��Ϣ
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); //�ļ��ϴ�����������request�����Ϣ
        if (commonsMultipartResolver.isMultipart(request)){ //�ж�request���Ƿ����ϴ����ļ���
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","�ϴ�ͼƬ����Ϊ��");
            return modelMap;
        }
        //2.ע�����
        if (shop!=null&&shopImg!=null){
            PersonInfo owner = new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);
            File shopImgFile = new File(PathUtil.getImgBasePath()+ ImageUtil.getRandomFileName());
            try {
                shopImgFile.createNewFile();
            } catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
                return modelMap;
            }
            try {
                inPutStreamToFile(shopImg.getInputStream(),shopImgFile);
            } catch (IOException e) {
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
                return modelMap;
            }
            ShopExecution se = shopService.addShop(shop,shopImgFile);
            if (se.getState()== ShopStateEnum.CHECK.getState()){
                modelMap.put("success",true);

            }else {
                modelMap.put("success",false);
                modelMap.put("success",se.getStateInfo());
            }
            return modelMap;         //3.���ؽ��
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","�����������Ϣ");
            return modelMap;
        }

    }

    private static void inPutStreamToFile(InputStream ins,File file){
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = ins.read(buffer))!=-1){
                os.write(buffer,0,bytesRead);
            }
        }catch (Exception e){
            throw new RuntimeException("����inputStreamToFileʱ�����쳣"+e.getMessage());
        }finally {
            try {
                if (os!=null){
                    os.close();
                }
                if (ins!=null){
                    ins.close();
                }
            }catch (Exception e){
                throw new RuntimeException("inputStreamToFile�ر�io�����쳣"+e.getMessage());
            }
        }
    }
}

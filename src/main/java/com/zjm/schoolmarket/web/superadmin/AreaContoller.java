package com.zjm.schoolmarket.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjm.schoolmarket.entity.Area;
import com.zjm.schoolmarket.service.AreaService;

//表明在spring容器下这是一个controller
@Controller
//和url路由相关
@RequestMapping("/superadmin")
public class AreaContoller {
	Logger logger = LoggerFactory.getLogger(AreaContoller.class);
	@Autowired // 在程序需要用到AreaService时将实现类注入进来
	private AreaService areaService; // 创建Service层实体类

	@RequestMapping(value = "/listArea", method = RequestMethod.GET) // 需要访问主目录下的哪个方法
	@ResponseBody // 将model对象自动转换为JSON对象返回给前端
	private Map<String, Object> listArea() {
		logger.info("====start====");
		long startTime = System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String, Object>(); // 变量modelMap:存放此方法的返回值
		List<Area> list = new ArrayList<Area>(); // 获取Service返回的区域列表
		try {
			list = areaService.getAreaList();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		logger.error("test error!");
		long endTime = System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",endTime-startTime);
		logger.info("====end====");
		return modelMap;
	}
}

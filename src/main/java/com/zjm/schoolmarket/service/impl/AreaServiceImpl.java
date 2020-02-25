package com.zjm.schoolmarket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjm.schoolmarket.dao.AreaDao;
import com.zjm.schoolmarket.entity.Area;
import com.zjm.schoolmarket.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
//    private final AreaDao areaDao;
//
//    public AreaServiceImpl(AreaDao areaDao) {
//        this.areaDao = areaDao;


    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

}

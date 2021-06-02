package com.chaofans.service.impl;

import com.chaofans.dao.GirlDao;
import com.chaofans.pojo.Girl;
import com.chaofans.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlDao girlDao;

    @Override
    public List<Girl> findAll() {
        return girlDao.findAll();
    }

    @Override
    public Girl findById(Integer id) {
        return girlDao.findById(id);
    }

    @Override
    public List<Girl> findByGirlQuery(Girl girl) {
        return girlDao.findByGirlQuery(girl);
    }

    @Override
    public Boolean insertGirl(Girl girl) {
        System.out.println("service1");
        boolean b = girlDao.insertGirl(girl) > 0;
        System.out.println("b:::::::"+b);
        return b;

    }

    @Override
    public Boolean updateGirl(Girl girl) {
        return girlDao.updateGirl(girl) > 0;
    }

    @Override
    public Boolean deleteGirl(Integer id) {
        return girlDao.deleteGirl(id) > 0;
    }
}

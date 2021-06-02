package com.chaofans.service;

import com.chaofans.pojo.Girl;

import java.util.List;

public interface GirlService {

    List<Girl> findAll();

    Girl findById(Integer id);

    List<Girl> findByGirlQuery(Girl girl);

    Boolean insertGirl(Girl girl);

    Boolean updateGirl(Girl girl);

    Boolean deleteGirl(Integer id);
}

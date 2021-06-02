package com.chaofans.dao;

import com.chaofans.pojo.Girl;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GirlDao {

    List<Girl> findAll();

    Girl findById(Integer id);

    List<Girl> findByGirlQuery(Girl girl);

    Integer insertGirl(Girl girl);

    Integer updateGirl(Girl girl);

    Integer deleteGirl(Integer id);
}

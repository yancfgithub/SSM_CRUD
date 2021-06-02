package com.chaofans.service.impl;

import com.chaofans.dao.FoodDao;
import com.chaofans.pojo.Food;
import com.chaofans.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;

    @Override
    public List<Food> selectAll() {
        return foodDao.selectAll();
    }

    @Override
    public Food selectFoodById(Integer id) {
        return foodDao.selectFoodById(id);
    }

    @Override
    public Boolean insertFood(Food food) {
        return foodDao.insertFood(food) > 0;
    }

    @Override
    public Boolean updateFood(Food food) {
        return foodDao.updateFood(food) > 0;
    }

    @Override
    public Boolean deleteFood(Integer id) {
        return foodDao.deleteFood(id) > 0;
    }
}

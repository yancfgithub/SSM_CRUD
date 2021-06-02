package com.chaofans.service;

import com.chaofans.pojo.Food;
import com.chaofans.pojo.Girl;

import java.util.List;

public interface FoodService {

    List<Food> selectAll();

    Food selectFoodById(Integer id);

    Boolean insertFood(Food food);

    Boolean updateFood(Food food);

    Boolean deleteFood(Integer id);
}

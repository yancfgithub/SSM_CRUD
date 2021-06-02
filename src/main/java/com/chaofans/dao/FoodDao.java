package com.chaofans.dao;

import com.chaofans.pojo.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDao {

    List<Food> selectAll();

    Food selectFoodById(Integer id);

    Integer insertFood(Food food);

    Integer updateFood(Food food);

    Integer deleteFood(Integer id);
}

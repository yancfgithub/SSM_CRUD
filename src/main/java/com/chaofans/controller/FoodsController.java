package com.chaofans.controller;

import com.chaofans.pojo.Food;
import com.chaofans.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodsController {

    @Autowired
    private FoodService foodService;

    @GetMapping("selectAll")
    List<Food> selectAll() {
        return foodService.selectAll();
    }

    @PostMapping("insert")
    Boolean insertFood(@RequestBody Food food){
        System.out.println(food);
        return foodService.insertFood(food);
    }

    @GetMapping("{fid}")
    Food selectFoodById(@PathVariable Integer fid) {
        return foodService.selectFoodById(fid);
    }


    @PostMapping("update")
    Boolean updateFood(@RequestBody Food food) {
        return foodService.updateFood(food);
    }

    @PostMapping("{fid}")
    Boolean deleteFood(@PathVariable Integer fid) {
        return foodService.deleteFood(fid);
    }


    @RequestMapping("/checkedFood")
    Food checkedFood() {
        List<Food> foods = selectAll();
        Double num = Math.floor(Math.random()*foods.size());
        String strNum = num.toString();
        int index = strNum.indexOf(".");
        String substring = strNum.substring(0, index);
        int local = Integer.parseInt(substring);

        return foods.get(local);
    }
}

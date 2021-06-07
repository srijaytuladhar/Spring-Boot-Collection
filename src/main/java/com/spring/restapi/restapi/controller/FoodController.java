package com.spring.restapi.restapi.controller;

import com.spring.restapi.restapi.Food;
import com.spring.restapi.restapi.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    // GET
    @RequestMapping("/foods")
    @CrossOrigin(origins = "http://localhost:9090")
    public List<Food> getFood() {
        return foodService.getFoods();
    }

    // GET students by id
    @RequestMapping("/foods/{id}")
    public Food getFoodById(@PathVariable String id) {
        return foodService.getFoodsById(id);
    }

}

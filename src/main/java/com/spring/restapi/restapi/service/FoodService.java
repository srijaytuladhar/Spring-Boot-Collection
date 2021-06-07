package com.spring.restapi.restapi.service;

import com.spring.restapi.restapi.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service        // business logic
public class FoodService implements FoodServiceInterface {

    private List<Food> foods = new ArrayList<>( Arrays.asList(
            new Food("1", "Pizza"),
            new Food("2", "Samosa"),
            new Food("3", "Pepsi"),
            new Food("4", "Fanta")
    ));



    @Override
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public Food getFoodsById(String id) {
        return foods.stream().filter(s->s.getId().equals(id)).findFirst().get();
    }
}

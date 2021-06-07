package com.spring.restapi.restapi.service;

import com.spring.restapi.restapi.Food;

import java.util.Collection;

public interface FoodServiceInterface {

    public abstract Collection<Food> getFoods();
    public abstract Food getFoodsById(String id);
}

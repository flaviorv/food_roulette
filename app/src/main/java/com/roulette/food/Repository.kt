package com.example.food

import androidx.lifecycle.LiveData
import com.example.food.database.Food
import com.example.food.database.FoodDao

class Repository(private val foodDao: FoodDao) {

    val allFoods: LiveData<List<Food>> = foodDao.getAllFoods()

    suspend fun insertFood(food: Food) { foodDao.insert(food)}

    suspend fun deleteFood(food: Food) { foodDao.delete(food)}

    suspend fun updateFood (food: Food) { foodDao.update(food)}
}
package com.example.food.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert( food: Food)

    @Delete
    suspend fun delete(food: Food)

    @Query("Select * From foodTable order by estabelecimento ASC")
    fun getAllFoods(): LiveData<List<Food>>

    @Update
    suspend fun update(food: Food)
}
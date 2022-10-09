package com.example.food

import android.app.Application
import android.graphics.Bitmap
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.food.activities.MainActivity
import com.example.food.database.Food
import com.example.food.database.FoodDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class FoodViewModel(application: Application): AndroidViewModel(application) {
    val allFoods: LiveData<List<Food>>
    val repository: Repository
    val imagem_baixada = MutableLiveData<Uri>()
    val randomId = MutableLiveData<Int>()





    init{
        val dao = FoodDatabase.getDatabase(application).getFoodDao()
        repository = Repository(dao)
        allFoods = repository.allFoods

    }

    fun deleteFood(food: Food) =viewModelScope.launch(Dispatchers.IO){
        repository.deleteFood(food)
    }

    fun updateFood(food: Food) =viewModelScope.launch(Dispatchers.IO) {
        repository.updateFood(food)
    }

    fun insertFood(food: Food) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertFood(food)
    }

}



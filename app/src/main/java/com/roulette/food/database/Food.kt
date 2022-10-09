package com.example.food.database

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foodTable")
data class Food(    val prato: String,
                    val imagem: Bitmap,
                    val estabelecimento: String,
                    val contato: String,
                    val informacoes: String,
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
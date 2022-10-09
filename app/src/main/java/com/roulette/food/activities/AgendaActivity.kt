package com.example.food.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food.*
import com.example.food.database.Food
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AgendaActivity : AppCompatActivity(),
    ClickUpdateInterface,
    ClickDeleteInterface {
    lateinit var viewModel: FoodViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var mAdView: AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(FoodViewModel::class.java)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val foodAdapter = FoodAdapter(this, this,this)
        recyclerView.adapter = foodAdapter

        viewModel.allFoods.observe(this, Observer { list -> list?.let{
            foodAdapter.updateList(it)
        }
        })



        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
            this.finish()
        }

    }

    override fun onUpdateInterface(food: Food){
        val intent = Intent(this, AddActivity::class.java)
        intent.putExtra("foodType", "Edit")
        intent.putExtra("food", food.prato)
        intent.putExtra("estabelecimento", food.estabelecimento)
        intent.putExtra("contato", food.contato)
        intent.putExtra("informacoes", food.informacoes)
        intent.putExtra("id", food.id)
        startActivity(intent)
    }

    override fun onDeleteInterface(food: Food) {
        // in on note click method we are calling delete
        // method from our view modal to delete our not.
        viewModel.deleteFood(food)
        // displaying a toast message
        Toast.makeText(this, "${food.prato} deleted", Toast.LENGTH_LONG).show()
    }

}
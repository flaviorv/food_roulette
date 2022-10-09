package com.example.food.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.food.FoodViewModel
import com.example.food.Fragmanets.InformacoesFragment
import com.example.food.Fragmanets.RoletaFragment
import com.example.food.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class InicioActivity : AppCompatActivity() {
    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        MobileAds.initialize(this)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(FoodViewModel::class.java)

        viewModel.allFoods.observe(this, Observer { list ->
            list?.let {
                if (viewModel.allFoods.value?.isNullOrEmpty() == true) {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, InformacoesFragment()).commit()

                }else{
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, RoletaFragment()).commit()

                }

            }
        })


    }
}
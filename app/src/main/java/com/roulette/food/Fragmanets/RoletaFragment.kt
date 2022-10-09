package com.example.food.Fragmanets

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.food.FoodViewModel
import com.example.food.R
import com.example.food.activities.AgendaActivity
import com.example.food.activities.InicioActivity
import com.example.food.activities.MainActivity

class RoletaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(Application())
        ).get(FoodViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_roleta, container, false)

        val nextscreen = view?.findViewById<Button>(R.id.nextscreen)
        nextscreen?.setOnClickListener{

            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)

        }
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=restaurants")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)}

        val btnEditar = view?.findViewById<Button>(R.id.btnEditar)
        btnEditar?.setOnClickListener{

            val intent = Intent(activity, AgendaActivity::class.java)
            startActivity(intent)


        }


        return view

    }


}
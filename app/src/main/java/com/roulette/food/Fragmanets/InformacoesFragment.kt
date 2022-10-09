package com.example.food.Fragmanets

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.food.R
import com.example.food.activities.AddActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class InformacoesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_informacoes, container, false)
        val btn2 =  view.findViewById<Button>(R.id.button2)
        btn2.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=restaurants")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)}
        val floatAdd = view.findViewById<FloatingActionButton>(R.id.adicionar_floatingActionButton)
        floatAdd.setOnClickListener{

            val intent = Intent(activity, AddActivity::class.java)
            startActivity(intent)

        }
        return view

    }

}
package com.example.food.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.food.FoodViewModel
import com.example.food.Fragmanets.InformacoesFragment
import com.example.food.Fragmanets.RoletaFragment
import com.example.food.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import java.util.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var mAdView: AdView
    lateinit var phone: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtFood = findViewById<TextView>(R.id.txtFood)
        val imagemFood = findViewById<ImageView>(R.id.imgFood)
        val txtEstabelecimento = findViewById<TextView>(R.id.txtEstabelecimento)
        val txtContato = findViewById<TextView>(R.id.txtContato)
        val txtInformacoes = findViewById<TextView>(R.id.txtInformacoes)
        val btnEscolher = findViewById<ImageButton>(R.id.btnEscolher)
        val imgLigar = findViewById<ImageView>(R.id.ligarImageView)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        val viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(FoodViewModel::class.java)


        Log.i("valorAlterado: randomId", "${viewModel.randomId.value}")

        viewModel.allFoods.observe(this, Observer { list -> list?.let {
            val getIds = viewModel.allFoods.value!!.lastIndex

            if(viewModel.randomId.value == null){
                if (viewModel.allFoods.value!!.size > 1) {
                    viewModel.randomId.value = Random.nextInt(0, getIds+1)
                    viewModel.randomId.value!!
                    Log.i("valorAlterado; getIds", "${getIds}")


                } else {
                    viewModel.randomId.value = 0
                }
            }
            viewModel.randomId.observe(this, Observer {
                val linha = viewModel.allFoods.value!!.get(viewModel.randomId.value!!)
                txtEstabelecimento.text = linha.estabelecimento.capitalize()
                imagemFood.setImageBitmap(linha.imagem)
                txtFood.text = linha.prato
                txtContato.text = "${linha.contato}"
                txtInformacoes.text = "Informação: ${linha.informacoes.capitalize()}"
                phone = linha.contato



            })
        }})
        txtContato.setOnClickListener { telaDiscagem(phone) }
        imgLigar.setOnClickListener { telaDiscagem(phone) }







        btnEscolher.setOnClickListener {

            viewModel.allFoods.observe(this, Observer { list ->
                list?.let {
                    val getIds = viewModel.allFoods.value!!.lastIndex
                    viewModel.randomId.value = Random.nextInt(0, getIds + 1)
                    Log.i("valorAlterado: randomId", "${viewModel.randomId.value}")
                }

            })

        }



    }

    private fun callDialog(mensagem: String,
                           permissions: Array<String>) {
        val mDialog = AlertDialog.Builder(this)
            .setTitle("Permissão")
            .setMessage(mensagem)
            .setPositiveButton("Ok")
            { dialog, id ->
                ActivityCompat.requestPermissions(
                    this@MainActivity, permissions,
                    REQUEST_PERMISSIONS_CODE)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel")
            { dialog, id ->
                dialog.dismiss()
            }
        mDialog.show()
    }


    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    val REQUEST_PERMISSIONS_CODE = 128
    fun telaDiscagem( phoneNumber: String) {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this, Manifest.permission.CALL_PHONE
                )) {
                callDialog(
                    "É preciso aceitar a permisão para ir para a tela de discagem.",
                    arrayOf(Manifest.permission.CALL_PHONE)
                )
            } else {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    REQUEST_PERMISSIONS_CODE)
            }
        } else {
            dialPhoneNumber(phoneNumber)
        }


    }

}
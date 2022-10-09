package com.example.food.activities

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.food.FoodViewModel
import com.example.food.R
import com.example.food.database.Food

private val RESULT_LOAD_IMAGE = 1

class AddActivity : AppCompatActivity() {

    private lateinit var galleryIntent: Intent
    private var imagemBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val imgUpload = findViewById<ImageView>(R.id.imgUpload)
        val edtFood = findViewById<TextView>(R.id.edtFood)
        val edtEstabelecimento = findViewById<TextView>(R.id.edtEstabelecimento)
        val edtContato = findViewById<TextView>(R.id.edtContato)
        val edtInformacoes = findViewById<TextView>(R.id.edtInformacoes)
        val salvarButton = findViewById<Button>(R.id.salvar_button)


        imgUpload.setOnClickListener{
            galleryIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE)
        }
        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(FoodViewModel::class.java)
        viewModel.imagem_baixada.observe(this, Observer {
                carregamento -> imgUpload.setImageURI(carregamento)
        })


        var editID = -1
        val foodType = intent.getStringExtra("foodType")
        if (foodType.equals("Edit")) {
            val food = intent.getStringExtra("food")
            val estabelecimento = intent.getStringExtra("estabelecimento")
            val contato = intent.getStringExtra("contato")
            val informacoes = intent.getStringExtra("informacoes")
            editID = intent.getIntExtra("id", -1)
            edtFood.setText(food)
            edtEstabelecimento.setText(estabelecimento)
            edtContato.setText(contato)
            edtInformacoes.setText(informacoes)
            salvarButton.setText("Atualizar Food")
        }

        salvarButton.setOnClickListener {
            val food = edtFood.text.toString()
            val estabelecimento = edtEstabelecimento.text.toString()
            val contato = edtContato.text.toString()
            val informacoes = edtInformacoes.text.toString()
            if (foodType.equals("Edit")) {
                if (food.isNotEmpty() && contato.isNotEmpty()  && imagemBitmap!= null && informacoes.isNotEmpty() ) {
                    val updateFood = Food(food, imagemBitmap!!, estabelecimento, contato, informacoes)
                    updateFood.id = editID
                    viewModel.updateFood(updateFood)
                    Toast.makeText(this, "Food atualizado", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, AgendaActivity::class.java)
                    startActivity(intent)
                    this.finish()

                }else {
                    Toast.makeText(this, "Dados incompletos", Toast.LENGTH_SHORT).show()
                }

            } else {
                if (food.isNotEmpty() && contato.isNotEmpty() && imagemBitmap != null && informacoes.isNotEmpty() ) {
                    viewModel.insertFood(Food(food, imagemBitmap!!, estabelecimento, contato, informacoes))
                    Toast.makeText(this, "Contato Salvo", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, AgendaActivity::class.java)
                    startActivity(intent)
                    this.finish()

                }else {
                    Toast.makeText(this, "Dados incompletos", Toast.LENGTH_SHORT).show()
                }

            }

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            ).get(FoodViewModel::class.java)
            val imgUpload = findViewById<ImageView>(R.id.imgUpload)
            val imagemUri = data.data
            imagemBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imagemUri)
            viewModel.imagem_baixada.value = imagemUri
            viewModel.imagem_baixada.observe(this, Observer {
                    carregamento -> imgUpload.setImageURI(carregamento)
            })
        }
    }

}

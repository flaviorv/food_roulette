package com.example.food

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.food.database.Food


class FoodAdapter(val context: Context,
                  val clickUpdateInterface: ClickUpdateInterface,
                      val clickDeleteInterface: ClickDeleteInterface) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    private val allFoods = ArrayList<Food>()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var txtFood: TextView = itemView.findViewById(R.id.pratoTextView)
        var txtEstabelecimento: TextView = itemView.findViewById(R.id.estabelecimentoTextView)
        var txtContato: TextView = itemView.findViewById(R.id.contatoTextView)
        var imgPrato: ImageView = itemView.findViewById(R.id.imgPrato)
        var deleteImageView : ImageView = itemView.findViewById(R.id.deleteImageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.food_item_recyclerview,
            parent,false)
        return ViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.txtFood.text = allFoods.get(position).prato.capitalize()
        holder.txtContato.text = allFoods.get(position).contato
        holder.txtEstabelecimento.text = allFoods.get(position).estabelecimento.capitalize()
        holder.imgPrato.setImageBitmap(allFoods.get(position).imagem)

        holder.deleteImageView.setOnClickListener {
            clickDeleteInterface.onDeleteInterface(allFoods.get(position))
        }
        holder.itemView.setOnClickListener{
            clickUpdateInterface.onUpdateInterface(allFoods.get(position))
        }

    }

    override fun getItemCount(): Int {
        return allFoods.size
    }
    fun updateList(newList: List<Food>) {
        allFoods.clear()
        allFoods.addAll(newList)
        notifyDataSetChanged()
    }
}
interface ClickDeleteInterface {
    fun onDeleteInterface(food: Food)
}
interface ClickUpdateInterface {
    fun onUpdateInterface(food: Food)
} // Criar função com api pra discagem no lugar desta
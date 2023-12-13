package com.example.pizzaapp

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ColorSpace.Model
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import model.MenuModel


class MenuAdapter (private val list: ArrayList<MenuModel>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){

    val data = listOf("aaa","bbbb","cccc","dddd","eeee","ffff","gggg","hhhh")


    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MenuAdapter.MenuViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardview_menu, parent, false)

        return MenuViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {

        holder.bind(list[position])
    }

    inner class MenuViewHolder(v:View):RecyclerView.ViewHolder(v) {
       val textId : TextView
       val textNama : TextView
       val textHarga : TextView
       val imageMenu : ImageView

        init {
            textId = v.findViewById(R.id.textIdMakanan)
            textNama = v.findViewById(R.id.textNamaMenu)
            textHarga = v.findViewById(R.id.textHargaMakanan)
            imageMenu = v.findViewById(R.id.imageMakanan)
        }

    fun bind (data: MenuModel) {
        val id:Int = data.id
        val nama:String = data.name
        val harga:Int = data.price
        val gambar:Bitmap = data.image

        textId.text = id.toString()
        textNama.text = nama
        textHarga.text = harga.toString()
        imageMenu.setImageBitmap(gambar)
        }
    }

}
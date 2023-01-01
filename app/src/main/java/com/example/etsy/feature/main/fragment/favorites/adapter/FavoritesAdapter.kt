package com.example.etsy.feature.main.fragment.favorites.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.etsy.R
import com.example.etsy.feature.detail.DetailActivity
import com.example.etsy.feature.main.fragment.home.adapter.TypeAdapter
import com.example.etsy.model.Type
import kotlinx.android.synthetic.main.item_fav.view.*
import kotlinx.android.synthetic.main.item_holiday_shirt.view.*

class FavoritesAdapter(
    val context: Context,
    val listFav: ArrayList<Type>


    ): RecyclerView.Adapter<FavoritesAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return FavoritesAdapter.MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_fav, parent, false)
        )
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listFav[position]
        holder.itemView.nameFav.text = item.topic
        holder.itemView.imgFav.setImageResource(item.img)
        holder.itemView.item_fav.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra("img", item.img)
            i.putExtra("topic", item.topic)
            i.putExtra("size", item.size)
            i.putExtra("price", item.price)
            i.putExtra("color", item.color)
            context.startActivity(i)
        }




        }

    override fun getItemCount(): Int {
        return listFav.size
    }
}

package com.example.etsy.feature.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.etsy.R
import com.example.etsy.feature.detail.DetailActivity
import com.example.etsy.model.Type
import kotlinx.android.synthetic.main.item_holiday.view.*

class TypeAdapter(val context: Context, val list: ArrayList<Type>): RecyclerView.Adapter<TypeAdapter.MyViewHolder>()

{
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_holiday, parent, false)
        )    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.itemView.img_shirt.setImageResource(item.img)
        holder.itemView.topic.text = item.topic

        when (position){
            0 -> holder.itemView.topic.setTextColor(Color.parseColor("#a5a8ad"))
            1 -> holder.itemView.topic.setTextColor(Color.parseColor("#127116"))
            2 -> holder.itemView.topic.setTextColor(Color.parseColor("#FF5722"))
            3 -> holder.itemView.topic.setTextColor(Color.parseColor("#FFC107"))
        }
        if (position%2 == 0){
            holder.itemView.topic.text = item.topic.uppercase()

        }else{
            holder.itemView.topic.text = item.topic.lowercase()
        }

        holder.itemView.item.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra("img", item.img)
            i.putExtra("topic", item.topic)
            context.startActivity(i)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}

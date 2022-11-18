package com.example.etsy.feature.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etsy.R
import com.example.etsy.model.Button
import kotlinx.android.synthetic.main.item_click_button.view.*
import kotlinx.android.synthetic.main.item_holiday.view.*

class ButtonAdapter(
    val context: Context,
    val list: ArrayList<Button>
): RecyclerView.Adapter<ButtonAdapter.MyViewHolder>()
{
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_click_button, parent, false)
        )    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        Glide.with(context).load(item.image).into(holder.itemView.icon)
        holder.itemView.name.text = item.name

    }

    override fun getItemCount(): Int {
        return list.size
    }


}
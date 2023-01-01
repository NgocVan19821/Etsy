package com.example.etsy.feature.main.fragment.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.etsy.R
import com.example.etsy.model.Type
import kotlinx.android.synthetic.main.item_holiday_shirt.view.*
import kotlinx.android.synthetic.main.item_section_holiday.view.*

class TypeAdapter(
    val context: Context,
    val listSection: ArrayList<String>,
    val list: ArrayList<Type>): RecyclerView.Adapter<TypeAdapter.MyViewHolder>()

{
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_section_holiday, parent, false)
        )    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listSection[position]
        holder.itemView.holiday.text = item

//        holder.itemView.item_holiday_tshirt.adapter = ProductAdapter(context, list)
    }

    override fun getItemCount(): Int {
        return 1
    }
}

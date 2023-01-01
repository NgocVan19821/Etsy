package com.example.etsy.feature.main.fragment.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etsy.R
import com.example.etsy.feature.detail.DetailActivity
import com.example.etsy.model.ProductDetail
import kotlinx.android.synthetic.main.item_holiday_shirt.view.*

class ProductAdapter(val context: Context, val list: ArrayList<ProductDetail>
): RecyclerView.Adapter<ProductAdapter.MyViewHolder>()

{
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_holiday_shirt, parent, false)
        )    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.itemView.title.text = item.title
        //holder.itemView.image_shirt.setImageResource(item.image)
        Glide.with(context)
            .load(item.img)
            .into(holder.itemView.image_shirt)

        holder.itemView.item_holiday_shirt.setOnClickListener {
            val i = Intent(context, DetailActivity::class.java)
            i.putExtra("id", item.id)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}

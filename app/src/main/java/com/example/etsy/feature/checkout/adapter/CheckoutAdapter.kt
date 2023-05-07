package com.example.etsy.feature.checkout.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etsy.R
import com.example.etsy.model.Cart
import com.example.etsy.ultities.Application
import kotlinx.android.synthetic.main.item_will_pay.view.*

class   CheckoutAdapter(
    val context: Context,
    val listCart: ArrayList<Cart>

    ):RecyclerView.Adapter<CheckoutAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return CheckoutAdapter.MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_will_pay, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listCart[position]
//        holder.itemView.imgItem.setImageResource(item.img)
        Glide.with(context)
            .load(item.img)
            .into(holder.itemView.imgItem)
        holder.itemView.nameItem.text = item.title
        holder.itemView.sizeItem.text = item.size
        holder.itemView.colorChange.backgroundTintList =
            ColorStateList.valueOf(context.resources.getColor(item.color!!))
        holder.itemView.quantityItem.text = item.quantity.toString()
        holder.itemView.priceItem.text = item.price.toString()
    }

    override fun getItemCount(): Int {
        return listCart.size
    }

}
package com.example.etsy.feature.main.fragment.cart.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etsy.R
import com.example.etsy.model.Cart
import com.example.etsy.model.ProductDetail
import com.example.etsy.model.Type
import com.example.etsy.ultities.Application
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.item_cart.view.*
import kotlinx.android.synthetic.main.item_holiday_shirt.view.*

class CartAdapter(
    val context: Context,
    val listCart: ArrayList<Cart>

): RecyclerView.Adapter<CartAdapter.MyViewHolder>() {
//    interface CartAdapterListener{
//        fun deleteItem(id: String)
//    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return CartAdapter.MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cart, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listCart[position]
        holder.itemView.item_name_cart.text = item.title
        Glide.with(context)
            .load(item.img)
            .into(holder.itemView.item_cart_img)
        holder.itemView.cartTotalPrice.text = (item.price?.times(item.quantity.toString().toInt())).toString()
        holder.itemView.item_cart_color.text = "Color: "
        holder.itemView.item_cart_size.text = item.size
        holder.itemView.colorChangeCart.backgroundTintList =
            ColorStateList.valueOf(context.resources.getColor(item.color.toString().toInt()))
       // holder.itemView.item_cart_img.setImageResource(item.img)
        holder.itemView.quantityCart.text = item.quantity.toString()

        holder.itemView.removeButton.setOnClickListener {
//            Application.cartList.remove(item)
//            notifyDataSetChanged()
//            listener.deleteItem(item.timeAddToCart.toString())
            val databaseCart = FirebaseDatabase.getInstance().getReference("Cart/${Application.dbPhone}")
            databaseCart.child(item.timeAddToCart.toString()).removeValue()
            if (Application.cartList.size == 1){
                Application.cartList.clear()
            }
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return listCart.size
    }
}

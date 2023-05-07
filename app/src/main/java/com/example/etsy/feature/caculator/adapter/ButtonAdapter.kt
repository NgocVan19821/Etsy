package com.example.etsy.feature.caculator.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.etsy.R
import kotlinx.android.synthetic.main.item_caculator.view.*

class ButtonAdapter(
        val context: Context,
        var listener: ButtonAdapterInterface,
        val listCalculator: ArrayList<String>



): RecyclerView.Adapter<ButtonAdapter.MyViewHolder>() {
        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

        interface ButtonAdapterInterface{
                fun didCalculator(item: String)
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                return ButtonAdapter.MyViewHolder(
                        LayoutInflater.from(parent.context)
                                .inflate(R.layout.item_caculator, parent, false)
                )
        }


        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                val item = listCalculator[position]
                holder.itemView.button.text = item
                holder.itemView.button.setOnClickListener {

                        listener.didCalculator(item)

                }
        }


        override fun getItemCount(): Int {
                return listCalculator.size
        }
}
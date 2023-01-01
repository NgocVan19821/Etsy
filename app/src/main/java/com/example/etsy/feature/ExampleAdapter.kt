package com.example.etsy.feature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.etsy.R
import com.example.etsy.model.nhom4dua
import kotlinx.android.synthetic.main.item_information.view.*

class ExampleAdapter(
    var infor : ArrayList<nhom4dua>

):RecyclerView.Adapter<ExampleAdapter.MyViewHolder>(

){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return ExampleAdapter.MyViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_information, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = infor[position]
        holder.itemView.ho.text = item.ho
        holder.itemView.ten.text = item.ten
        holder.itemView.tuoi.text = item.tuoi.toString()
        if(item.gtinh == true){
            holder.itemView.gioiTinh.text = "Nữ"

        }else{
            holder.itemView.gioiTinh.text = "Nam"


        }
    }

    override fun getItemCount(): Int {
        return infor.size
    }

}
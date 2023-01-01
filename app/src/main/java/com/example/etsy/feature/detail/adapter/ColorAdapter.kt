package com.example.etsy.feature.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.etsy.R
import com.example.etsy.model.Color
import com.example.etsy.viewmodels.AttributeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.item_color.view.*

class ColorAdapter(
    var context: BottomSheetDialogFragment,
    var viewModel: ViewModelStoreOwner,
    var color : ArrayList<Color>


):RecyclerView.Adapter<ColorAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private lateinit var attributeViewModel: AttributeViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = color[position]
        attributeViewModel = ViewModelProvider(viewModel).get(AttributeViewModel::class.java)
        holder.itemView.nameColor.text = item.nameColor
        holder.itemView.colorChange.background.setTint(context.resources.getColor(item.color))

        holder.itemView.item_color.setOnClickListener {
            attributeViewModel.color.value = item.color
            attributeViewModel.nameColor.value = item.nameColor
            context.dismiss()
        }

    }

    override fun getItemCount(): Int {
        return color.size
    }
}
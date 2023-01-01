package com.example.etsy.feature.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.etsy.R
import com.example.etsy.model.Color
import com.example.etsy.model.Size
import com.example.etsy.viewmodels.AttributeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.item_color.view.*
import kotlinx.android.synthetic.main.item_size.view.*

class SizeAdapter(
    var context: BottomSheetDialogFragment,
    var viewModel: ViewModelStoreOwner,
    var size : ArrayList<Size>

):RecyclerView.Adapter<SizeAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private lateinit var attributeViewModel: AttributeViewModel


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeAdapter.MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_size, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = size[position]
        attributeViewModel = ViewModelProvider(viewModel).get(AttributeViewModel::class.java)
        holder.itemView.nameSize.text = item.size
        holder.itemView.price.text = item.price.toString()

        holder.itemView.item_size.setOnClickListener {
            attributeViewModel.size.value = item.size
            attributeViewModel.price.value = item.price
            context.dismiss()


        }


    }

    override fun getItemCount(): Int {
        return size.size
    }

}

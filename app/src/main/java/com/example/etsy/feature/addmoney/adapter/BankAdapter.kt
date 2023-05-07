package com.example.etsy.feature.addmoney.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.etsy.R
import com.example.etsy.model.Datum
import com.example.etsy.viewmodels.AttributeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.item_bank.view.*
import kotlinx.android.synthetic.main.item_color.view.*
import kotlinx.android.synthetic.main.item_will_pay.view.*

class BankAdapter(
    var context: BottomSheetDialogFragment,
    var viewModel: ViewModelStoreOwner,
    var list : List<Datum>


):RecyclerView.Adapter<BankAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    private lateinit var attributeViewModel: AttributeViewModel



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_bank, parent, false)
        )

    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        attributeViewModel = ViewModelProvider(viewModel).get(AttributeViewModel::class.java)
        Glide.with(context)
            .load(item.logo)
            .into(holder.itemView.imgBank)
        holder.itemView.nameBank.text = item.name
        holder.itemView.item_bank.setOnClickListener{
            attributeViewModel.nameBank.value = item.name
            attributeViewModel.imgBank.value = item.logo
            context.dismiss()



        }

        }

    override fun getItemCount(): Int {
        return list.size
    }

}
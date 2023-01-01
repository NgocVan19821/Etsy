package com.example.etsy.feature.detail.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.etsy.R
import com.example.etsy.feature.detail.adapter.SizeAdapter
import com.example.etsy.model.Size
import com.example.etsy.ultities.Application
import com.example.etsy.viewmodels.AttributeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_size.*


class SizeFragment : BottomSheetDialogFragment() {
    private lateinit var attributeViewModel: AttributeViewModel





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attributeViewModel = ViewModelProvider(requireActivity()).get(AttributeViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_size, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpDataColor()
    }
    private fun setUpDataColor(){
        item_list_size.adapter = SizeAdapter(this, requireActivity(), Application.listSize)
    }

}
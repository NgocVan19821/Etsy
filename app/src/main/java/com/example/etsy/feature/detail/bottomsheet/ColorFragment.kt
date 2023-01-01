package com.example.etsy.feature.detail.bottomsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.etsy.R
import com.example.etsy.feature.detail.adapter.ColorAdapter
import com.example.etsy.model.Color
import com.example.etsy.ultities.Application
import com.example.etsy.viewmodels.AttributeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_color.*

class ColorFragment : BottomSheetDialogFragment() {

    private lateinit var attributeViewModel: AttributeViewModel
    val listColor: ArrayList<Color> = arrayListOf(
        Color("Black", R.color.black),
        Color("Green", R.color.green),
        Color("Grey", R.color.grey),
        Color("Orange", R.color.orange),
        Color("Pink", R.color.pink),
        Color("Yellow", R.color.yellow),
        Color("White", R.color.white)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attributeViewModel = ViewModelProvider(requireActivity()).get(AttributeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpDataColor()
    }

    private fun setUpDataColor(){
        item_list_color.adapter = ColorAdapter(this, requireActivity(), listColor)
    }
}
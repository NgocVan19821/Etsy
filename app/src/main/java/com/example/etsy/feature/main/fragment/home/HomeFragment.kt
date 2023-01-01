package com.example.etsy.feature.main.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.etsy.R
import com.example.etsy.feature.main.fragment.home.adapter.ProductAdapter
import com.example.etsy.model.*
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_example.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var databaseProduct: DatabaseReference
    private var productDetail: ArrayList<ProductDetail> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // setUpHoliday()
        setUpdatabase()
    }
    private fun setUpdatabase() { // ket noi dung voi duong dan
        databaseProduct = FirebaseDatabase.getInstance().getReference("ProductDetail")
        fetchData()

    }
    private fun fetchData() { //lay data
        databaseProduct.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    productDetail.clear()
                    for (productSnapshot in snapshot.children) {
                        val item = productSnapshot.getValue(ProductDetail::class.java)
                        productDetail.add(item!!)
                    }

                    holiday_shirt.adapter = ProductAdapter(requireContext(), productDetail)
//                   information.sortByDescending { it.ho }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    //private fun setUpHoliday(){
     //   holiday_shirt.adapter = TypeAdapter(requireActivity(), listSection, Application.list)
   // }


}
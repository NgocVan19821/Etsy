package com.example.etsy.feature.main.fragment.cart

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.etsy.R
import com.example.etsy.feature.checkout.CheckoutActivity
import com.example.etsy.feature.main.fragment.cart.adapter.CartAdapter
import com.example.etsy.feature.main.fragment.home.adapter.ProductAdapter
import com.example.etsy.model.Cart
import com.example.etsy.model.ProductDetail
import com.example.etsy.ultities.Application
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_cart.*


class CartFragment : Fragment(), CartAdapter.CartAdapterListener {
    private lateinit var databaseCart: DatabaseReference
    private var productCart: ArrayList<Cart> = arrayListOf()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //list_cart.adapter = CartAdapter(requireContext(), Application.cartList)
        setUpdatabase()

    }
    private fun setUpdatabase() {
        databaseCart = FirebaseDatabase.getInstance().getReference("Cart/${Application.dbPhone}")
        fetchData()
        eventListener()

    }
    private fun fetchData() { //lay data
        databaseCart.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    Application.cartList.clear()

                    for (productSnapshot in snapshot.children) {
                        Log.d("yyy", "${snapshot.childrenCount}")
                        val item = productSnapshot.getValue(Cart::class.java)
                        Application.cartList.add(item!!)
                    }
                    list_cart.adapter = CartAdapter(requireContext(), Application.cartList)
//                   information.sortByDescending { it.ho }
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    private fun changeText(){
    }

    fun checkIfFragmentAttached(operation: Context.() -> Unit) {
        if (isAdded && context != null) {
            operation(requireContext())
        }
    }

    private fun eventListener(){
        btn_checkOut.setOnClickListener {
                if(Application.cartList.size > 0){
                    startActivity(Intent(requireContext(), CheckoutActivity::class.java))

                }else{
                    Toast.makeText(requireActivity(),"Add product", Toast.LENGTH_SHORT).show()
                }
        }


    }
    private fun checkCart(){

    }

    override fun deleteItem(id: String) {
    }


}
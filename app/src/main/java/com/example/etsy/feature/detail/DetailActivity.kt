package com.example.etsy.feature.detail

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.etsy.R
import com.example.etsy.feature.detail.bottomsheet.ColorFragment
import com.example.etsy.feature.detail.bottomsheet.SizeFragment
import com.example.etsy.model.Cart
import com.example.etsy.model.ProductDetail
import com.example.etsy.ultities.Application
import com.example.etsy.viewmodels.AttributeViewModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DetailActivity : AppCompatActivity() {

    private lateinit var attributeViewModel: AttributeViewModel
    var colorGet = R.color.white
    var urlImg = ""
    private var productDetail: ArrayList<ProductDetail> = arrayListOf()
    private lateinit var databaseProduct: DatabaseReference
    private lateinit var databaseCart: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        attributeViewModel = ViewModelProvider(this)[AttributeViewModel::class.java]

        getDataItem()
        setUpListener()
        checkData()
        eventListener()
    }

    private fun getDataItem() {
        val id = intent.getIntExtra("id", 0)
        databaseProduct = FirebaseDatabase.getInstance().getReference("ProductDetail")
        databaseCart = FirebaseDatabase.getInstance().getReference("Cart/${Application.dbPhone}")



        price.text = Application.listSize[0].price.toString()
        sizeText.text = Application.listSize[0].size
        colorChange.setBackgroundResource(R.drawable.bg_circle)


        fetchData(id)

        calculateTotalPrice()

    }
    private fun fetchData(idGet: Int) {
        databaseProduct.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    productDetail.clear()

                    for (productSnapshot in snapshot.children) {
                        val item = productSnapshot.getValue(ProductDetail::class.java)
                        productDetail.add(item!!)
                    }

                    for (i in productDetail){
                        if (i.id == idGet){
                            urlImg = i.img!!
                            Glide.with(this@DetailActivity).load(i.img).into(imgP)
                            Application.listSize[0].price = i.price!!.toDouble()
                            titleP.text = i.title
                            description.text = i.description
                            break
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    private fun setUpListener() {
        buttonPickColor.setOnClickListener {
            ColorFragment().show(supportFragmentManager, "colorPikcer")
        }
        buttonPickSize.setOnClickListener {
            SizeFragment().show(supportFragmentManager, "sizePicker")
        }
    }

    private fun checkData() {
        attributeViewModel.color.observe(this) {
            colorGet = it
            colorChange.backgroundTintList = ColorStateList.valueOf(resources.getColor(it))
            nameColorTextView.setTextColor(ContextCompat.getColor(applicationContext, it))

        }

        attributeViewModel.nameColor.observe(this) {
            nameColorTextView.text = it
        }
        attributeViewModel.size.observe(this) {
            sizeText.text = it
        }
        attributeViewModel.price.observe(this) {
            price.text = it.toString()
            calculateTotalPrice()
        }


    }

    private fun didAdd() {
        val x = quantity.text.toString().toInt() + 1
        quantity.text = x.toString()
        calculateTotalPrice()

    }

    private fun didMinus() {
        var x = quantity.text.toString().toInt()
        if (x > 1) {
            x--
            quantity.text = x.toString()
            calculateTotalPrice()
        }


    }

    private fun calculateTotalPrice() {
        var x = price.text.toString().toDouble()
        var y = quantity.text.toString().toInt()
        defaultPrice.text = (x * y).toString()


    }

    private fun addProductCart() {
        val time = Calendar.getInstance().time
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm::ss")
        val description = description.text.toString()
        val title = titleP.text.toString()
        val quantity = quantity.text.toString().toInt()
        val size = sizeText.text.toString()
        val price = price.text.toString().toDouble()

        val cartProduct = Cart(
            intent.getIntExtra("id", 0),
            urlImg,
            description,
            price,
            title,
            quantity,
            size,
            colorGet,
            formatter.format(time)
        )


        databaseCart.child(formatter.format(time)).setValue(cartProduct)
            .addOnSuccessListener {
               Toast.makeText(this@DetailActivity, "e e e e", Toast.LENGTH_SHORT).show()
                finish()
            }
    }

    private fun eventListener() {
        plus.setOnClickListener {
            didAdd()

        }
        minus.setOnClickListener {
            didMinus()
        }

        btn_addToCart.setOnClickListener {
//            val cart = Type(
//                intent.getIntExtra("img", 0),
//                intent.getStringExtra("topic").toString(),
//                false,
//                sizeText.text.toString(),
//                price.text.toString().toDouble(),
//                colorGet,
//                quantity.text.toString().toInt()
//            )
//            Application.cartList.add(cart)
            addProductCart()
        }
    }


}
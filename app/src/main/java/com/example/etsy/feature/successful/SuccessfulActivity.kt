package com.example.etsy.feature.successful

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etsy.R
import com.example.etsy.feature.checkout.CheckoutActivity
import com.example.etsy.feature.main.MainActivity
import com.example.etsy.feature.main.fragment.cart.CartFragment
import com.example.etsy.ultities.Application
import kotlinx.android.synthetic.main.activity_successful.*

class SuccessfulActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_successful)
        eventlistener()
    }
    private fun eventlistener(){
        btn_back.setOnClickListener {
           onBackPressed()
            Application.cartList.clear()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
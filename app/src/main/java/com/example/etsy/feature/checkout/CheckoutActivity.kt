package com.example.etsy.feature.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.etsy.R
import com.example.etsy.feature.checkout.adapter.CheckoutAdapter
import com.example.etsy.feature.successful.SuccessfulActivity
import com.example.etsy.ultities.Application
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity() {

    var totalCartPirce: Double = 0.0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        calculator()

//        for (i in Application.cartList){
//            totalCartPirce += (i.price*i.quantity)
//        }
        totalPrice.text = totalCartPirce.toString()
        totalCart.text = (totalCartPirce + 30).toString()
        eventlistener()
        onRadioButtonClicked(radio_visa)
        onRadioButtonClicked(radio_paypal)
        onRadioButtonClicked(radio_masterCard)
        eventListenerRadioBtn()




    }

    override fun onResume() {
        super.onResume()
        list_item_checkout.adapter = CheckoutAdapter(this@CheckoutActivity)
    }
    private fun calculator(){
        for(i in Application.cartList){
            if (i.quantity != null && i.price != null){
                totalCartPirce += (i.quantity * i.price)
            }

        }

        totalPrice.text = totalCartPirce.toString()
    }
    private fun eventlistener(){
        switchShippingFee.setOnClickListener {
            if (switchShippingFee.isChecked){
                totalCart.text = (totalCartPirce).toString()
            }else{
                totalCart.text = (totalCartPirce + 30).toString()
            }
        }
        btn_Payment.setOnClickListener {
            val databaseCart = FirebaseDatabase.getInstance().getReference("Cart")
            databaseCart.child(Application.dbPhone).removeValue()

            val i = Intent(this,SuccessfulActivity::class.java)
            startActivity(i)

            finish()

        }

    }
    private fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            when (view.getId()) {
                R.id.radio_visa ->
                    if (checked) {
                        imgP.setImageResource(R.drawable.img_mastercard)

                            Log.d("ngocvan", "visa")
                    }
                R.id.radio_paypal ->
                    if (checked) {
                        imgP.setImageResource(R.drawable.img)
                        Log.d("ngocvan", "paypal")


                    }
                R.id.radio_masterCard ->
                    if (checked) {
                        imgP.setImageResource(R.drawable.img_mastercard)
                        Log.d("ngocvan", "masterCard")



                    }
            }
        }
    }
    private fun eventListenerRadioBtn() {
        radio_visa.setOnClickListener {
            imgP.setImageResource(R.drawable.img)
        }
        radio_paypal.setOnClickListener {
            imgP.setImageResource(R.drawable.img_mastercard)
        }
        radio_masterCard.setOnClickListener {
            imgP.setImageResource(R.drawable.img)
        }





    }


}


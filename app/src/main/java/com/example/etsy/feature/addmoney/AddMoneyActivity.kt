package com.example.etsy.feature.addmoney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.etsy.R
import com.example.etsy.feature.addmoney.bottomsheet.BankFragment
import com.example.etsy.ultities.Application
import com.example.etsy.viewmodels.AttributeViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_money.*

class AddMoneyActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference

    private lateinit var attributeViewModel: AttributeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_money)
        attributeViewModel = ViewModelProvider(this).get(AttributeViewModel::class.java)

        eventListener()
        checkData()
        setUpdatabase()
    }
    private fun eventListener(){
        btn_pickBank.setOnClickListener {
            BankFragment().show(supportFragmentManager, "bankPicker")

        }
        enterM.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if (count > 0)
                    total(s.toString().toDouble())
                else
                    totalM.text = money_current.text
            }
        })
        btn_addMoney.setOnClickListener {
            if (enterM.text.isNotEmpty())
                this.updateMoney(totalM.text.toString().toDouble())
        }
    }

    private fun checkData() {


        attributeViewModel.nameBank.observe(this) {
            nameBankC.text = it
        }
        attributeViewModel.imgBank.observe(this) {
            Glide.with(this)
                .load(it)
                .into(imgBankC)
        }
    }
    private fun setUpdatabase() { // ket noi dung voi duong dan
        database = FirebaseDatabase.getInstance().getReference("Account")
        fetchData()

    }
    private fun fetchData() {
        database.child(Application.dbPhone).get().addOnSuccessListener {
            if (it.exists()){
                money_current.text = it.child("money").value.toString()

            }

        }.addOnFailureListener {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
    }

    private fun total(money: Double){
        var y = money_current.text.toString().toDouble()
        totalM.text = (money + y).toString()
    }
    private fun updateMoney(money: Double){
        val moneyS = mapOf<String, Double>(
            "money" to money
        )

        database.child(Application.dbPhone).updateChildren(moneyS).addOnSuccessListener {
            Toast.makeText(this, "Your wallet has $${money}", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    }
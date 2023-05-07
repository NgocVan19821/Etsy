package com.example.etsy.feature.caculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etsy.R
import com.example.etsy.feature.caculator.adapter.ButtonAdapter
import com.example.etsy.feature.checkNumberOne
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity(), ButtonAdapter.ButtonAdapterInterface {
    val item = arrayListOf<String>(
        "%",
        "CE",
        "C",
        "Delete",
        "7",
        "8",
        "9",
        "X",
        "4",
        "5",
        "6",
        "-",
        "1",
        "2",
        "3",
        "+",
        "0",
        "=",












        )

    var firstValue = 0
    var lastValue = 0
    var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        list_item_button.adapter = ButtonAdapter(this, this,  item)
        2.checkNumberOne()
    }

    @SuppressLint("SetTextI18n")
    override fun didCalculator(item: String) {
        if (item == "+" || item == "-" || item == "%" || item == "x"){
            text.text = "${text2.text} $item"

            firstValue = text.text.toString().toInt() + text2.text.toString().toInt()
            text2.text = "0"
            operator = item
        }



    }

    private fun calculator(operator: String){
        when (operator){
            "+" -> {

            }
        }
    }
}
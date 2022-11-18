package com.example.etsy.feature.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etsy.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getDataItem()
    }
    private fun getDataItem(){
        val img = intent.getIntExtra("img",0)
        val topic : String = intent.getStringExtra("topic").toString()
        titleP.text = topic
        imgP.setImageResource(img)
    }

}
package com.example.etsy.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etsy.R
import com.example.etsy.feature.main.adapter.ButtonAdapter
import com.example.etsy.feature.main.adapter.TypeAdapter
import com.example.etsy.model.Button
import com.example.etsy.model.Type
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val listType = arrayListOf(

        Type(R.drawable.img_halloween, "Halloween"),
        Type(R.drawable.img_halloween, "Christmas"),
        Type(R.drawable.img_halloween, "Valentine"),
        Type(R.drawable.img_halloween, "Thanksgiving")

        )
    val listButton = arrayListOf(
        Button(R.drawable.ic_favorite, "Home"),
        Button(R.drawable.ic_home, "Favorites"),
        Button(R.drawable.ic_user, "You"),
        Button(R.drawable.ic_cart, "Cart")


        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchData()
    }
    private fun fetchData(){
        list_item_holiday.adapter = TypeAdapter(this@MainActivity, listType)
        click_button.adapter = ButtonAdapter(this@MainActivity, listButton)

    }

}
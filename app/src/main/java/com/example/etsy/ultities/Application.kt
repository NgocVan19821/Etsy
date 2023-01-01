package com.example.etsy.ultities

import android.app.Application
import com.example.etsy.R
import com.example.etsy.model.Cart
import com.example.etsy.model.Size
import com.example.etsy.model.Type
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Application: Application() {
    companion object{
        var listSize: ArrayList<Size> = arrayListOf(
            Size("Unisex's T-Shirt S",50.000),
            Size("Unisex's T-Shirt M",500.056),
            Size("Unisex's T-Shirt L",550.000),
            Size("Unisex's T-Shirt XL",600.000),
            Size("Unisex's T-Shirt 2XL",650.000),
            Size("Unisex's T-Shirt 3XL",700.000),
            Size("Unisex's T-Shirt 4XL",750.000)

        )



        var favouriteList: ArrayList<Type> = arrayListOf()
        var cartList: ArrayList<Cart> = arrayListOf()

        var codePhone = "codePhone"
        var codePassword = "codePassword"
        var dbPhone = "databasePhone"
//        URL api
        const val baseURL = "https://fakestoreapi.com/"

    }
}
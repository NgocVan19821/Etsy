package com.example.etsy.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.etsy.R
import com.example.etsy.feature.main.fragment.cart.CartFragment
import com.example.etsy.feature.main.fragment.favorites.FavoritesFragment
import com.example.etsy.feature.main.fragment.home.HomeFragment
import com.example.etsy.feature.main.fragment.notifications.NotificationsFragment
import com.example.etsy.feature.main.fragment.person.PersonFragment
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(

) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        menu_bottom_nav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.notifications -> replaceFragment(NotificationsFragment())
                R.id.person -> replaceFragment(PersonFragment())
                R.id.cart -> replaceFragment(CartFragment())
                else ->{

                }
            }
            true
        }

        fetchData()
        replaceFragment(HomeFragment())
    }
    private fun fetchData(){
//        list_item_holiday.adapter = TypeAdapter(this@MainActivity, listType)

    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contentLayout, fragment)
        fragmentTransaction.commit()

    }


}
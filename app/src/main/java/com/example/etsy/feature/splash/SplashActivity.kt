package com.example.etsy.feature.splash

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etsy.R
import com.example.etsy.feature.login.LoginActivity
import com.example.etsy.feature.main.MainActivity
import com.example.etsy.ultities.Application
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SplashActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        database = FirebaseDatabase.getInstance().getReference("Account")

        fetchData()
    }
    private fun fetchData(){
        val sharedPreference =  getSharedPreferences("NAME", Context.MODE_PRIVATE)
        val defaultValuePhone = sharedPreference.getString(Application.codePhone,"").toString()
        val defaultValuePass = sharedPreference.getString(Application.codePassword,"").toString()
        database.child(defaultValuePhone).get().addOnSuccessListener{
            if(it.exists()){
                if(it.child("password").value.toString() == defaultValuePass){
                    Application.dbPhone = defaultValuePhone
                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                    startActivity(intent)                }
            }
            finish()
        }

    }



}
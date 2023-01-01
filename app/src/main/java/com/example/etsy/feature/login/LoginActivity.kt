package com.example.etsy.feature.login
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.etsy.R
import com.example.etsy.feature.main.MainActivity
import com.example.etsy.feature.main.fragment.home.HomeFragment
import com.example.etsy.feature.register.RegisterActivity
import com.example.etsy.ultities.Application
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_register
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        database = FirebaseDatabase.getInstance().getReference("Account")

        eventListener()
    }
    private fun eventListener() {
        btn_register.setOnClickListener {
            val i = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(i)
        }
        btn_login.setOnClickListener {
            if(phoneR.text.toString() == "")
                Toast.makeText(
                    this,"Nhap SDT", Toast.LENGTH_SHORT
                ).show()
            else{
                database.child(phoneR.text.toString()).get().addOnSuccessListener {
                    if (it.exists()){
                        if(it.child("phone").value.toString() == (phoneR.text.toString()) && it.child("password").value.toString() == (passwordR.text.toString()) ){

                            saveKey(phoneR.text.toString(), passwordR.text.toString())
                            val a = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(a)
                            finish()

                        }
                        else{
                            Toast.makeText(this, "Your account hasn't existed", Toast.LENGTH_SHORT).show()

                        }

                    }
                    else{
                        Toast.makeText(this, "Your account hasn't existed", Toast.LENGTH_SHORT).show()
                    }

                    }


                }

        }

    }
    private fun saveKey(phone: String, pass: String){
        val sharedPreference =  getSharedPreferences("NAME", Context.MODE_PRIVATE)//tạo db preference_name với private
        var editor = sharedPreference.edit()
        editor.putString(Application.codePhone,phone)
        editor.putString(Application.codePassword, pass)
        editor.commit()// gui len

    }

//   private fun setUpDatabase() {
//       database = FirebaseDatabase.getInstance().getReference("Account")
//
//   }


}
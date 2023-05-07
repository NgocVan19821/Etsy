package com.example.etsy.feature.edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.etsy.R
import com.example.etsy.model.Account
import com.example.etsy.ultities.Application
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_edit_account.*
import kotlinx.android.synthetic.main.activity_login.*

class EditAccountActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_account)
        database = FirebaseDatabase.getInstance().getReference("Account")
        database.child(Application.dbPhone).get().addOnSuccessListener {
            if (it.exists()){
                fullName.setText(it.child("fullName").value.toString())
                email.setText(it.child("email").value.toString())
                phone.setText(it.child("phone").value.toString())
            }


        }.addOnFailureListener {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
        eventListener()

    }
    private fun eventListener(){
        btn_editAccount.setOnClickListener {
            val fullName = fullName.text.toString()
            val email = email.text.toString()
            val phoneM = phone.text.toString()
            updateAccount(fullName,email,phoneM)
        }
    }
    private fun updateAccount(fullName: String, email: String, phone: String){
        val account = mapOf<String,String>(
            "fullName" to fullName,
            "phone" to phone,
            "email" to email
        )
        database.child(Application.dbPhone).updateChildren(account).addOnSuccessListener {
            finish()
            Toast.makeText(this,"Successfully",Toast.LENGTH_SHORT).show()

        }


    }

}
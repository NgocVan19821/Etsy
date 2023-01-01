package com.example.etsy.feature.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.etsy.R
import com.example.etsy.feature.login.LoginActivity
import com.example.etsy.model.Account
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.btn_register

class RegisterActivity : AppCompatActivity() {
    private lateinit var databaseAccount: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        btn_register.setOnClickListener {
//            signUp()
//
//            account()
//            finish()
            checkConditionBeforeRegister()
        }

    }
    private fun account() {

        databaseAccount = FirebaseDatabase.getInstance().getReference("Account")

        val fullname = fullName.text.toString()
        val email = email.text.toString()
        val phone = phone.text.toString()
        val pass = password.text.toString()

        val register = Account(
            fullname,
            email,
            phone,
            pass,
            0.0,
            0.0
        )
        databaseAccount.child(phone).setValue(register)
            .addOnSuccessListener {
              //  Toast.makeText(this@RegisterActivity, "Sucessfully", Toast.LENGTH_SHORT).show()

            }

    }
    private fun signUp() {

        if( fullName.text.length < 3){
            fullName.error = "Please enter name"
            fullName.requestFocus()


        }
//        if(email.text.toString().isEmpty()){
//            email.error = "Please enter email"
//            email.requestFocus()
//            return
//
//        }else{
//            android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()
//        }
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            btn_register.isEnabled = true
        }else{
            btn_register.isEnabled = false
            email.error = "Enter email again"
        }
        if(phone.text.toString().isEmpty() || phone.length() <10){
            phone.error = "Please enter your phone"
            phone.requestFocus()
            return

        }
        if(password.text.toString().isEmpty()){
            password.error = "Please enter password"
            password.requestFocus()



        }else{
            password!!.error = null

        }
        if(confirm_password.text.toString().isEmpty() || confirm_password != password){
            confirm_password.error = "Please enter password again"
            confirm_password.requestFocus()


        }else{
            confirm_password!!.error = null

        }


    }

    private fun checkConditionBeforeRegister(){
        if (fullName.text.length in 6..20){
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                if(phone.text.length == 10){
                    if(password.text.length in 10..20){
                        Log.d("123", password.text.toString())
                        Log.d("123", confirm_password.text.toString())
                        if(confirm_password.text.toString() == password.text.toString()){
                            if( btn_agree.isChecked){
                                account()
                                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                                startActivity(intent)
                                finish()

                            }else{
                                toast("Please agree")


                            }


                        }else{
                            toast("Nhap lai password")

                        }

                    }else{
                        toast("Khong hop le")

                    }
                }else{
                    toast("So dien thoai khong hop le")
                }

            }else
                toast("Nhap email sai")
        }else {
            toast("Nhap sai ten")
        }
    }

    private fun toast(content: String){
        Toast.makeText(this@RegisterActivity, content, Toast.LENGTH_SHORT).show()
    }
}
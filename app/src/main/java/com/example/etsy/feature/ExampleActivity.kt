package com.example.etsy.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.etsy.R
import com.example.etsy.model.nhom4dua
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_example.*

class ExampleActivity : AppCompatActivity() {
    private lateinit var databaseCart: DatabaseReference
    private var information: ArrayList<nhom4dua> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        setUpDatabase()
        fetchData()

    }
    private fun setUpDatabase() {
        databaseCart = FirebaseDatabase.getInstance().getReference("nhom4dua")



    }
    private fun fetchData() {
       databaseCart.addValueEventListener(object : ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               if (snapshot.exists()) {
                   information.clear()
                   for (productSnapshot in snapshot.children) {
                       val item = productSnapshot.getValue(nhom4dua::class.java)
                       information.add(item!!)

                   }
                   list_item_iT.adapter = ExampleAdapter(information)
//                   information.sortByDescending { it.ho }
               }

           }

           override fun onCancelled(error: DatabaseError) {
           }
       })
    }


}
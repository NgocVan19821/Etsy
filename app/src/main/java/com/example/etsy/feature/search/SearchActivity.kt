package com.example.etsy.feature.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.example.etsy.R
import com.example.etsy.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = arrayOf("Tu", "Van","Anh Man","Anh Quan","Anh Duong","Anh Phu","Tu", "Van","Anh Man","Anh Quan","Anh Duong","Anh Phu","Anh Duong","Anh Phu","Tu", "Van","Anh Man","Anh Quan","Anh Duong","Anh Phu")
        val userAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            user
        )
        binding.userList.adapter = userAdapter
        binding.btnSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.btnSearchView.clearFocus()
                if(user.contains(query)){
                    userAdapter.filter.filter(query)
                }
                return false
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                userAdapter.filter.filter(newText)
                return false
            }

        }
        )
    }
}
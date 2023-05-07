package com.example.etsy.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.etsy.R
import java.util.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
//        swapInList(mutableListOf("a", "b"))
//        mutableListOf("a", "b", "c").swap()
//        mutableListOf("t", "h", "c").swap()
//        val int: Int = 1
//        int.checkNumberOne()
//        2.checkNumberOne()
//        Toast.makeText(this, "d", Toast.LENGTH_SHORT).show()
//        "d".toast()
        "d".checkTrinh()
        changeMoney(18.5, "USD").toString().toast()
        mutableListOf("a", "b", "c").swap(1, 1)
    }
    fun swapInList(list: MutableList<String>){
        val dataChange = list[0]
        list[0] = list[1]
        list[1] = dataChange
        println(list)
    }

    fun changeMoney(money: Double, currency: String): Double{
        when (currency){
            "USD" -> return money * 23570
            "JPY" -> return money * 17938
            "China" -> return money *100301
            else -> return 0.0
        }


    }

    fun MutableList<String>.swap(firstIndex: Int, changeIndex: Int){
       // if (firstIndex < this.size && changeIndex < this.size){
            val temp = this[firstIndex]
            this[firstIndex] = this[changeIndex]
            this[changeIndex] = temp
            Log.d("Result", "$this")
        // if (firstIndex < this.size && changeIndex < this.size){

//        }else{
//            Log.d("Result", "Sai index")
//        }

    }



    fun String.toast(){
        Toast.makeText(applicationContext, this, Toast.LENGTH_SHORT).show()
    }
}

fun Int.checkNumberOne(){
    if (this == 1){
        Log.d("Result:", "It's number one")
    }else{
        Log.d("Result:", "It isn't number one")
    }

}
fun String.checkTrinh(){
    if (this == "Trinh"){
        Log.d("No: ","Khoa")

    }else{
        Log.d("No: ", "Trinh")
    }
}



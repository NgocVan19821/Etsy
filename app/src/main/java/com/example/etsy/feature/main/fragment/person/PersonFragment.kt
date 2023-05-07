package com.example.etsy.feature.main.fragment.person

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.example.etsy.R
import com.example.etsy.feature.addmoney.AddMoneyActivity
import com.example.etsy.feature.edit.EditAccountActivity
import com.example.etsy.feature.login.LoginActivity
import com.example.etsy.model.Color
import com.example.etsy.ultities.Application
import kotlinx.android.synthetic.main.dialog_logout.*
import kotlinx.android.synthetic.main.fragment_person.*


class PersonFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventListener()
    }
    private fun eventListener(){
        logOut.setOnClickListener{
            showDialog()
        }
        btn_personal.setOnClickListener {
            val i = Intent(requireActivity(), EditAccountActivity::class.java)
            startActivity(i)
        }
        btn_addMoney.setOnClickListener {
            val i = Intent(requireActivity(), AddMoneyActivity::class.java)
            startActivity(i)
        }
    }
    private fun showDialog() {
        val dialog = Dialog(requireActivity())
        dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_logout)
        dialog.show()

        dialog.ok.setOnClickListener {
            removeKey()
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        dialog.cancel.setOnClickListener {
            dialog.dismiss()
        }
    }

    fun removeKey(){
        val sharedPreference =  requireContext().getSharedPreferences("NAME", Context.MODE_PRIVATE)//tạo db preference_name với private
        val editor = sharedPreference.edit()
        editor.remove(Application.codePhone)
        editor.remove(Application.codePassword)
        editor.commit()// gui len
    }
}
package com.example.etsy.feature.addmoney.bottomsheet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.etsy.R
import com.example.etsy.api.EndpointAPI
import com.example.etsy.feature.addmoney.adapter.BankAdapter
import com.example.etsy.model.ResponseBank
import com.example.etsy.ultities.Application
import com.example.etsy.viewmodels.AttributeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bank.*
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit


class BankFragment : BottomSheetDialogFragment() {
    private lateinit var attributeViewModel: AttributeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attributeViewModel = ViewModelProvider(requireActivity()).get(AttributeViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setUpBankList()
    }

    private fun setUpBankList(){
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Application.baseURL)
            .build()
            .create(EndpointAPI::class.java)

        val retrofitData = retrofit.getBank()
        retrofitData.enqueue(object : Callback<ResponseBank>{
            /** Successful HTTP response.  */
            override fun onResponse(response: Response<ResponseBank>?, retrofit: Retrofit?) {
                val data = response!!.body()
                item_list_bank.adapter = BankAdapter(this@BankFragment,requireActivity(), data.data!!)
            }

            /** Invoked when a network or unexpected exception occurred during the HTTP request.  */
            override fun onFailure(t: Throwable?) {
                Log.e("error", "${t?.message}")
            }

        })
    }
}
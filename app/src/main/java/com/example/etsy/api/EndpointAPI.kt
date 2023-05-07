package com.example.etsy.api

import com.example.etsy.model.ResponseBank
import retrofit.Call
import retrofit.http.GET

interface EndpointAPI {

    @GET("banks")
    fun getBank(): Call<ResponseBank>
}
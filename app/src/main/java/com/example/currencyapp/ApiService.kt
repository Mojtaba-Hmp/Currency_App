package com.example.currencyapp


import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("latest/?api_key=freeWo7Rx52WI5ywvtvW53yAZndJAuut")

    fun getData() : Call<String>
}
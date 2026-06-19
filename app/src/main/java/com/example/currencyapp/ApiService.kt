package com.example.currencyapp


import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("latest/?api_key=freeNGJtcqX1AzHvBxwRke7jjQ60Qx2E")

    fun getData() : Call<String>
}
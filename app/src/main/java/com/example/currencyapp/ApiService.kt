package com.example.currencyapp


import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
//    @GET("Mojtaba-Hmp/testJson/blob/main/myjson.json")
    @GET("latest/?api_key=freedYL4pVKpnZjKZieXuSvJpQpfz0k9")

    fun getData() : Call<String>
}
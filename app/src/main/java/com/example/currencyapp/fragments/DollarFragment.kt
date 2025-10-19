package com.example.currencyapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyapp.ApiService
import com.example.currencyapp.DataClass
import com.example.currencyapp.adapter.MyAdapter
import com.example.currencyapp.currencyMap
import com.example.currencyapp.databinding.FragmentDollarBinding
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class DollarFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentDollarBinding.inflate(LayoutInflater.from(activity),container, false)

        binding.progressBar.visibility = View.VISIBLE

        val fragmentTitlePriceList = mutableListOf<DataClass>()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.navasan.tech/")
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        val call = apiService.getData()


        val keyList = currencyMap.keys

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {

                val jsonObject = JSONObject(response.body()!!)
                val jsonNamesArray = jsonObject.names()

                for (i in 0 until jsonNamesArray.length()) {
                    val title = jsonNamesArray.optString(i)

                    if (title in keyList) {
                        try {
                            val price = jsonObject.getJSONObject(title).getInt("value")
                            val change = jsonObject.getJSONObject(title).getInt("change")

                            fragmentTitlePriceList.add(DataClass(title, price, change))
                        } catch (e: Exception) {
                            Log.e("myTag", "خطا در پارس کردن ارز: $title", e)
                        }
                    }
                }

                binding.dollarRecyclerView.layoutManager = LinearLayoutManager(activity)
                binding.dollarRecyclerView.adapter = MyAdapter(fragmentTitlePriceList)
                binding.progressBar.visibility = View.GONE


            }
            override fun onFailure(call: Call<String?>, t: Throwable) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(activity, "عملیات ناموفق بود", Toast.LENGTH_SHORT).show()
            }

        })

    return binding.root

    }

}




package com.example.currencyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.CurrencyInfo
import com.example.currencyapp.DataClass
import com.example.currencyapp.R
import com.example.currencyapp.currencyMap
import com.example.currencyapp.databinding.RecyclerLayoutBinding

class MyAdapter(val adapterTitlePriceList: MutableList<DataClass>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RecyclerLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(RecyclerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))





    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = adapterTitlePriceList[position]
        val rawTitle = item.title

        // پیدا کردن اولین تطابق
        val match = currencyMap.entries.firstOrNull { entry ->
            rawTitle.contains(entry.key)
        }

        val currencyInfo = match?.value ?: CurrencyInfo(rawTitle, R.drawable.world_flag)

        // نمایش
        holder.binding.title.text = currencyInfo.prettyName
        holder.binding.price.text = item.price.toString() +  "  "   + "تومان"

        var changeColor: Int
        if (item.change < 0) {
            changeColor = R.color.changeTextRed
            holder.binding.change.text = "-" + item.change.toString()
            holder.binding.change.setTextColor(ContextCompat.getColor(holder.itemView.context, changeColor))
        }else if(item.change > 0){
            changeColor = R.color.changeTextGreen
            holder.binding.change.text = "+" + item.change.toString()
            holder.binding.change.setTextColor(ContextCompat.getColor(holder.itemView.context, changeColor))
        }else if(item.change == 0){
            changeColor = R.color.text
            holder.binding.change.text = item.change.toString()
            holder.binding.change.setTextColor(ContextCompat.getColor(holder.itemView.context, changeColor))
        }




        holder.binding.flagImageView.setImageResource(currencyInfo.flagResId)

    }

    override fun getItemCount(): Int {
        return  adapterTitlePriceList.size
    }


}
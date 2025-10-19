package com.example.currencyapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.currencyapp.fragments.DollarFragment
import com.example.currencyapp.fragments.GoldFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        if (position==0){
            return GoldFragment()
        } else {
            return DollarFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}
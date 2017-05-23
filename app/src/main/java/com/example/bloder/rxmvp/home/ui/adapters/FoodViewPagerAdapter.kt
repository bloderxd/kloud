package com.example.bloder.rxmvp.home.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.bloder.rxmvp.home.ui.fragments.FavoriteFoodFragment
import com.example.bloder.rxmvp.home.ui.fragments.FoodFragment

/**
 * Created by bloder on 22/05/17.
 */
class FoodViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val fragments by lazy { listOf(FoodFragment(), FavoriteFoodFragment()) }

    override fun getItem(position: Int): Fragment = fragments[position]
    override fun getCount(): Int = fragments.size
}
package com.example.bloder.rxmvp.home.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.bloder.rxmvp.home.representers.state.MainFoodStateRepresenter
import com.example.bloder.rxmvp.home.ui.fragments.BaseMainFragment
import com.example.bloder.rxmvp.home.ui.fragments.DessertFragment
import com.example.bloder.rxmvp.home.ui.fragments.FavoriteFoodFragment
import com.example.bloder.rxmvp.home.ui.fragments.FoodFragment

/**
 * Created by bloder on 22/05/17.
 */
class FoodViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val fragments by lazy {
        hashMapOf(
                MainFoodStateRepresenter.FoodFragmentId()         to  FoodFragment(),
                MainFoodStateRepresenter.DessertFragmentId()      to  DessertFragment(),
                MainFoodStateRepresenter.FavoriteFoodFragmentId() to  FavoriteFoodFragment()
        )
    }

    override fun getItem(position: Int): Fragment = get(position)
    override fun getCount(): Int = fragments.size

    fun updateState(type : MainFoodStateRepresenter, ref: BaseMainFragment) {
        fragments[type] = ref
    }

    private fun get(position: Int) : Fragment = when (position) {
            1 -> fragments[MainFoodStateRepresenter.FoodFragmentId()]!!
            2 -> fragments[MainFoodStateRepresenter.FoodFragmentId()]!!
            3 -> fragments[MainFoodStateRepresenter.FoodFragmentId()]!!
            else -> Fragment()
    }
}
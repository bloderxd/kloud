package com.example.bloder.rxmvp.home.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.bloder.rxmvp.home.arch.FoodContract
import com.example.bloder.rxmvp.home.representers.state.MainFoodStateRepresenter
import com.example.bloder.rxmvp.home.ui.fragments.DessertFragment
import com.example.bloder.rxmvp.home.ui.fragments.FavoriteFoodFragment
import com.example.bloder.rxmvp.home.ui.fragments.FoodFragment

/**
 * Created by bloder on 22/05/17.
 */
class FoodViewPagerAdapter(fragmentManager: FragmentManager, private var stateProvider: FoodContract.View) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = get(position)
    override fun getCount(): Int = stateProvider.state.size

    private fun get(position: Int) : Fragment = when (position) {
            1 -> stateProvider.restoreFrom(MainFoodStateRepresenter.FoodFragmentId())?: Fragment()
            2 -> stateProvider.restoreFrom(MainFoodStateRepresenter.DessertFragmentId())?:Fragment()
            3 -> stateProvider.restoreFrom(MainFoodStateRepresenter.FavoriteFoodFragmentId())?:Fragment()
            else -> Fragment()
    }

    fun updateStateProvider(stateProvider: FoodContract.View) {
        this.stateProvider = stateProvider
    }
}
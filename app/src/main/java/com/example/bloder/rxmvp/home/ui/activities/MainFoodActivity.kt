package com.example.bloder.rxmvp.home.ui.activities

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.bloder.rxmvp.R
import com.example.bloder.rxmvp.home.arch.FoodContract
import com.example.bloder.rxmvp.home.identifiers.ChildId
import com.example.bloder.rxmvp.home.ui.adapters.FoodViewPagerAdapter
import com.example.bloder.rxmvp.home.ui.delegates.ViewPagerDelegate
import com.example.bloder.rxmvp.home.ui.fragments.FavoriteFoodFragment
import com.example.bloder.rxmvp.home.ui.fragments.FoodFragment

class MainFoodActivity : AppCompatActivity(), FoodContract.View {

    override val state: HashMap<ChildId, Fragment> = hashMapOf()
    override var rxTicket by reactive()
    private val tab       by lazy { findViewById(R.id.tab) as TabLayout }
    private val viewPager by ViewPagerDelegate(this,  R.id.view_pager, FoodViewPagerAdapter(supportFragmentManager))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_food)
        startCooking()
    }

    override fun onFoodFetched() {}

    override fun defaultStateInitialization() : HashMap<ChildId, Fragment> = hashMapOf(
            ChildId.FOOD      to FoodFragment(),
            ChildId.FAVORITES to FavoriteFoodFragment()
    )

    private fun startCooking() {
        tab.setupWithViewPager(viewPager)
        tab.getTabAt(0)!!.text = "Food"
        tab.getTabAt(1)!!.text = "My Favorites Food"
    }
}

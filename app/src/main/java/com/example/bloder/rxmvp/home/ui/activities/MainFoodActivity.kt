package com.example.bloder.rxmvp.home.ui.activities

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.bloder.rxmvp.R
import com.example.bloder.rxmvp.home.arch.FoodContract
import com.example.bloder.rxmvp.home.arch.FoodPresenter
import com.example.bloder.rxmvp.home.representers.MainFoodRepresenter
import com.example.bloder.rxmvp.home.representers.state.MainFoodStateRepresenter
import com.example.bloder.rxmvp.home.ui.adapters.FoodViewPagerAdapter
import com.example.bloder.rxmvp.home.ui.delegates.ViewPagerDelegate
import com.example.bloder.rxmvp.home.ui.fragments.DessertFragment
import com.example.bloder.rxmvp.home.ui.fragments.FavoriteFoodFragment
import com.example.bloder.rxmvp.home.ui.fragments.FoodFragment
import java.util.*
import kotlin.reflect.KProperty

class MainFoodActivity : AppCompatActivity(), FoodContract.View {

    private val tab       by lazy { findViewById(R.id.tab) as TabLayout }
    private val viewPager by ViewPagerDelegate(this,  R.id.view_pager, FoodViewPagerAdapter(supportFragmentManager, this))
    override var presenter by lazy { FoodPresenter(this) }
    override var state: HashMap<MainFoodStateRepresenter, Fragment> = hashMapOf(
            MainFoodStateRepresenter.FoodFragmentId()         to  FoodFragment(),
            MainFoodStateRepresenter.DessertFragmentId()      to  DessertFragment(),
            MainFoodStateRepresenter.FavoriteFoodFragmentId() to  FavoriteFoodFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_food)
        turnOnStateReceiver()
        configView()
    }

    private fun configView() {
        tab.setupWithViewPager(viewPager)
        tab.getTabAt(0)?.text = "Food"
        tab.getTabAt(1)?.text = "Dessert"
        tab.getTabAt(2)?.text = "Favorites"
    }

    override fun onReceiveState(representer: MainFoodStateRepresenter) {
        saveState(representer, representer.ref)
        (viewPager.adapter as FoodViewPagerAdapter).updateStateProvider(this)
    }

    override fun getStateRepresenter(): Class<MainFoodStateRepresenter> = MainFoodStateRepresenter::class.java
    override fun getRepresenter(): Class<MainFoodRepresenter> = MainFoodRepresenter::class.java
    override fun onReceive(event: MainFoodRepresenter) {}
    private operator fun <T> Lazy<T>.setValue(mainFoodActivity: MainFoodActivity, property: KProperty<*>, t: Any) {}
}

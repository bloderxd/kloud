package com.example.bloder.rxmvp.home.ui.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.example.bloder.rxmvp.R
import com.example.bloder.rxmvp.home.arch.FoodContract
import com.example.bloder.rxmvp.home.arch.FoodPresenter
import com.example.bloder.rxmvp.home.representers.MainFoodRepresenter
import com.example.bloder.rxmvp.home.representers.state.MainFoodStateRepresenter
import com.example.bloder.rxmvp.home.ui.fragments.DessertFragment
import com.example.bloder.rxmvp.home.ui.fragments.FavoriteFoodFragment
import com.example.bloder.rxmvp.home.ui.fragments.FoodFragment
import kotlin.reflect.KProperty

class MainFoodActivity : AppCompatActivity(), FoodContract.View {

    private val food            by lazy { findViewById(R.id.food) as ImageView }
    private val dessert         by lazy { findViewById(R.id.dessert) as ImageView }
    private val favorite        by lazy { findViewById(R.id.favorites) as ImageView }
    override var presenter      by lazy { FoodPresenter(this) }
    override var state by lazy { hashMapOf(
            MainFoodStateRepresenter.FoodFragmentObject        to  FoodFragment(),
            MainFoodStateRepresenter.DessertFragmentObject      to  DessertFragment(),
            MainFoodStateRepresenter.FavoriteFragmentObject to  FavoriteFoodFragment()
    ) as HashMap<MainFoodStateRepresenter, Fragment> }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_food)
        turnOnStateReceiver()
        configView()
    }

    private fun configView() {
        food.setOnClickListener { updateFragment(state[MainFoodStateRepresenter.FavoriteFragmentObject]) }
        dessert.setOnClickListener { updateFragment(state[MainFoodStateRepresenter.DessertFragmentObject]) }
        favorite.setOnClickListener { updateFragment(state[MainFoodStateRepresenter.FavoriteFragmentObject]) }
    }

    private fun updateFragment(frag: Fragment?) {
        supportFragmentManager.beginTransaction().replace(R.id.container, frag).commit()
    }

    override fun onReceiveState(representer: MainFoodStateRepresenter) {
        saveState(representer.refObject, representer.ref)
    }

    override fun getStateRepresenter(): Class<MainFoodStateRepresenter> = MainFoodStateRepresenter::class.java
    override fun getRepresenter(): Class<MainFoodRepresenter> = MainFoodRepresenter::class.java
    override fun onReceive(event: MainFoodRepresenter) {}
    private operator fun <T> Lazy<T>.setValue(mainFoodActivity: MainFoodActivity, property: KProperty<*>, t: Any) {}
}

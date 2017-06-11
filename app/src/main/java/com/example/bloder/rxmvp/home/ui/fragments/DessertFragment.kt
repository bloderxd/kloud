package com.example.bloder.rxmvp.home.ui.fragments

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.arch.FoodContract
import com.example.bloder.rxmvp.home.representers.FoodPresenterRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.DessertFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.FavoriteFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.state.MainFoodStateRepresenter

/**
 * Created by bloder on 23/05/17.
 */
class DessertFragment : BaseMainFragment(), FoodContract.DessertView {

    override fun onDessertsFetched(desserts: List<Food>) {
        updateList(desserts)
    }

    override fun askForDesserts() {
        cloud().post(FoodPresenterRepresenter.FetchDesserts)
    }

    override fun onReceive(event: DessertFragmentRepresenter) {
        when(event) {
            is DessertFragmentRepresenter.DessertFetched -> onDessertsFetched(event.desserts)
        }
    }

    override fun addToFavorites(food: Food) {
        cloud().post(FavoriteFragmentRepresenter.AddFavorite(food))
    }

    override fun work() {
        initAdapter({ food -> addToFavorites(food) })
        registerReceiver()
        askForDesserts()
    }

    override fun getRepresenter(): Class<DessertFragmentRepresenter>  = DessertFragmentRepresenter::class.java
    override fun getStateRepresenter(): MainFoodStateRepresenter.DessertFragmentId = MainFoodStateRepresenter.DessertFragmentId(this)
}

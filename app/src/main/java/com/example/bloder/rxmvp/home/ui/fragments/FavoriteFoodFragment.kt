package com.example.bloder.rxmvp.home.ui.fragments

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.arch.FoodContract
import com.example.bloder.rxmvp.home.representers.fragments.FavoriteFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.state.MainFoodStateRepresenter

/**
 * Created by bloder on 22/05/17.
 */
class FavoriteFoodFragment : BaseMainFragment(), FoodContract.FavoriteView {

    override fun addFavoriteFood(food: Food) {
        updateList(listOf(food))
    }

    override fun removeFavoriteFood(food: Food) {
        removeFromList(food)
    }

    override fun onReceive(event: FavoriteFragmentRepresenter) {
        when(event) {
            is FavoriteFragmentRepresenter.AddFavorite -> run { addFavoriteFood(event.food) }
        }
    }

    override fun work() {
        initAdapter({ food -> removeFavoriteFood(food) })
        registerReceiver()
    }

    override fun getRepresenter(): Class<FavoriteFragmentRepresenter> = FavoriteFragmentRepresenter::class.java
}
package com.example.bloder.rxmvp.home.ui.fragments

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.arch.FoodContract
import com.example.bloder.rxmvp.home.representers.FoodPresenterRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.FavoriteFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.FoodFragmentRepresenter

/**
 * Created by bloder on 22/05/17.
 */
class FoodFragment : BaseMainFragment(), FoodContract.FoodView {

    override fun onFoodsFetched(foods: List<Food>) {
        updateList(foods)
    }

    override fun work() {
        initAdapter({ food ->  addToFavorites(food) })
        registerReceiver()
        askForFoods()
    }

    override fun addToFavorites(food: Food) {
        cloud().post(FavoriteFragmentRepresenter.AddFavorite(food))
    }

    override fun askForFoods() {
        cloud().post(FoodPresenterRepresenter.FetchFood)
    }

    override fun onReceive(event: FoodFragmentRepresenter) {
        when(event) {
            is FoodFragmentRepresenter.FoodFetched -> onFoodsFetched(event.foods)
        }
    }

    override fun getRepresenter(): Class<FoodFragmentRepresenter> = FoodFragmentRepresenter::class.java
}
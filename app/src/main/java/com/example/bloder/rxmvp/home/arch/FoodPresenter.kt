package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.representers.FoodPresenterRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.DessertFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.FoodFragmentRepresenter

/**
 * Created by bloder on 20/05/17.
 */
class FoodPresenter(override val view: FoodContract.View) : FoodContract.Presenter {

    override val interactor by lazy { FoodInteractor(this) }

    init { registerReceiver() }

    override fun fetchDesserts() {
        interactor.fetchDesserts()
    }

    override fun fetchFoods() {
        interactor.fetchFoods()
    }

    override fun onFoodsFetched(foods: List<Food>) {
        cloud().post(FoodFragmentRepresenter.FoodFetched(foods))
    }

    override fun onDessertsFetched(desserts: List<Food>) {
        cloud().post(DessertFragmentRepresenter.DessertFetched(desserts))
    }

    override fun onReceive(event: FoodPresenterRepresenter) {
        when(event) {
            is FoodPresenterRepresenter.FetchFood     -> fetchFoods()
            is FoodPresenterRepresenter.FetchDesserts -> fetchDesserts()
        }
    }

    override fun getRepresenter(): Class<FoodPresenterRepresenter> = FoodPresenterRepresenter::class.java
}

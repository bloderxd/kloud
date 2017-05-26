package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.representers.FoodPresenterRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.FoodFragmentRepresenter

/**
 * Created by bloder on 20/05/17.
 */
class FoodPresenter(override val view: FoodContract.View) : FoodContract.Presenter {

    override val interactor by lazy { FoodInteractor(this) }
    override var cloud by cloud()

    init { registerReceiver() }

    override fun fetchFood() {
        interactor.fetchFood()
    }

    override fun onFoodFetched(foods: List<Food>) {
        cloud.post(FoodFragmentRepresenter.FoodFetched(foods))
    }

    override fun onReceive(event: FoodPresenterRepresenter) {
        when(event) {
            is FoodPresenterRepresenter.FetchFood -> fetchFood()
            is FoodPresenterRepresenter.FoodFetched -> onFoodFetched(event.foods)
        }
    }

    override fun getRepresenter(): Class<FoodPresenterRepresenter> = FoodPresenterRepresenter::class.java
}

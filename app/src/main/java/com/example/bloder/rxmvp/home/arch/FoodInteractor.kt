package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.api.Api

/**
 * Created by bloder on 20/05/17.
 */
class FoodInteractor(override var presenter: FoodContract.Presenter) : FoodContract.Interactor {

    override fun fetchFoods() {
        presenter.onFoodsFetched(Api.mockFoods())
    }

    override fun fetchDesserts() {
        presenter.onDessertsFetched(Api.mockDesserts())
    }
}
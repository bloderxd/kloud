package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.base_arch.mvp.RxBasePresenter

/**
 * Created by bloder on 20/05/17.
 */
class FoodInteractor(override var presenter: RxBasePresenter<*>) : FoodContract.Interactor {

    override fun fetchFood() {
        // FETCH FOOD
    }
}
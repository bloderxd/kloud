package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.base_presenter.RxBasePresenter
import com.example.bloder.rxmvp.data.Food

/**
 * Created by bloder on 20/05/17.
 */
class FoodContract {

    interface View {
        fun onFoodFetched()
    }

    interface Presenter<T> : RxBasePresenter<T> {
        fun fetchFood()
        fun onFoodFetched()
    }

    interface Interactor {
        fun fetchFood() : Food
    }
}
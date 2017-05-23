package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.base_arch.RxBasePresenter
import com.example.bloder.rxmvp.base_arch.RxBaseView
import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.identifiers.ChildId

/**
 * Created by bloder on 20/05/17.
 */
class FoodContract {

    interface View : RxBaseView<ChildId> {
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
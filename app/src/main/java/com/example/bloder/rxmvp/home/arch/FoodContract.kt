package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.base_arch.mvp.BaseInteractor
import com.example.bloder.rxmvp.base_arch.mvp.RxBasePresenter
import com.example.bloder.rxmvp.base_arch.mvp.view.StateKeeperRxBaseView
import com.example.bloder.rxmvp.base_arch.mvp.view.StateProviderRxBaseView
import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.identifiers.fragments.FoodChildViewId
import com.example.bloder.rxmvp.home.identifiers.state.ChildId

/**
 * Created by bloder on 20/05/17.
 */
class FoodContract {

    interface View : StateKeeperRxBaseView<ChildId> {
        fun onFoodFetched(foods: List<Food>)
    }

    interface FoodView : StateProviderRxBaseView<FoodChildViewId> {
        fun onFoodFetched(foods: List<Food>)
    }

    interface Presenter<T> : RxBasePresenter<T> {
        fun fetchFood()
        fun onFoodFetched(foods: List<Food>)
    }

    interface Interactor : BaseInteractor {
        fun fetchFood()
    }
}
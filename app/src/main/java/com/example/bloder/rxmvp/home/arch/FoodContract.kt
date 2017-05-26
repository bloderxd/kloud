package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.base_arch.mvp.BaseInteractor
import com.example.bloder.rxmvp.base_arch.mvp.RxBasePresenter
import com.example.bloder.rxmvp.base_arch.mvp.view.InventoryRxBaseView
import com.example.bloder.rxmvp.base_arch.mvp.view.ProviderRxBaseView
import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.representers.FoodPresenterRepresenter
import com.example.bloder.rxmvp.home.representers.MainFoodRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.FoodFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.state.MainFoodStateRepresenter

/**
 * Created by bloder on 20/05/17.
 */
class FoodContract {

    interface View : InventoryRxBaseView<MainFoodRepresenter, MainFoodStateRepresenter>

    interface FoodView : ProviderRxBaseView<FoodFragmentRepresenter, MainFoodStateRepresenter.FoodFragmentId> {
        fun onFoodFetched(foods: List<Food>)
    }

    interface Presenter : RxBasePresenter<FoodPresenterRepresenter> {
        fun fetchFood()
        fun onFoodFetched(foods: List<Food>)
    }

    interface Interactor : BaseInteractor {
        fun fetchFood()
    }
}
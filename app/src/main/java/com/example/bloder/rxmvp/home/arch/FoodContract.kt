package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.base_arch.mvp.BaseInteractor
import com.example.bloder.rxmvp.base_arch.mvp.RxBasePresenter
import com.example.bloder.rxmvp.base_arch.mvp.view.InventoryRxBaseView
import com.example.bloder.rxmvp.base_arch.mvp.view.ProviderRxBaseView
import com.example.bloder.rxmvp.base_arch.mvp.view.RxBaseView
import com.example.bloder.rxmvp.base_arch.rx.CloudProtocol
import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.representers.FoodPresenterRepresenter
import com.example.bloder.rxmvp.home.representers.MainFoodRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.DessertFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.FavoriteFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.FoodFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.state.MainFoodStateRepresenter

/**
 * Created by bloder on 20/05/17.
 */
class FoodContract {

    interface View : RxBaseView<MainFoodRepresenter>

    interface FoodView : CloudProtocol<FoodFragmentRepresenter> {
        fun onFoodsFetched(foods: List<Food>)
        fun askForFoods()
        fun addToFavorites(food: Food)
    }

    interface DessertView : CloudProtocol<DessertFragmentRepresenter> {
        fun onDessertsFetched(desserts: List<Food>)
        fun askForDesserts()
        fun addToFavorites(food: Food)
    }

    interface FavoriteView : CloudProtocol<FavoriteFragmentRepresenter> {
        fun addFavoriteFood(food: Food)
        fun removeFavoriteFood(food: Food)
    }

    interface Presenter : RxBasePresenter<FoodPresenterRepresenter> {
        fun fetchFoods()
        fun fetchDesserts()
        fun onFoodsFetched(foods: List<Food>)
        fun onDessertsFetched(desserts: List<Food>)
    }

    interface Interactor : BaseInteractor {
        fun fetchFoods()
        fun fetchDesserts()
    }
}
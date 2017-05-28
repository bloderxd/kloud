package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.base_arch.mvp.BaseInteractor
import com.example.bloder.rxmvp.base_arch.mvp.RxBasePresenter
import com.example.bloder.rxmvp.base_arch.mvp.view.InventoryRxBaseView
import com.example.bloder.rxmvp.base_arch.mvp.view.ProviderRxBaseView
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

    interface View : InventoryRxBaseView<MainFoodRepresenter, MainFoodStateRepresenter>

    interface FoodView : ProviderRxBaseView<FoodFragmentRepresenter, MainFoodStateRepresenter.FoodFragmentId> {
        fun onFoodsFetched(foods: List<Food>)
        fun askForFoods()
        fun addToFavorites(food: Food)
    }

    interface DessertView : ProviderRxBaseView<DessertFragmentRepresenter, MainFoodStateRepresenter.DessertFragmentId> {
        fun onDessertsFetched(desserts: List<Food>)
        fun askForDesserts()
        fun addToFavorites(food: Food)
    }

    interface FavoriteView : ProviderRxBaseView<FavoriteFragmentRepresenter, MainFoodStateRepresenter.FavoriteFoodFragmentId> {
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
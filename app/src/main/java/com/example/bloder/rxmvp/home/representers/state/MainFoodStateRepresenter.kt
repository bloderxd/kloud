package com.example.bloder.rxmvp.home.representers.state

import android.support.v4.app.Fragment
import com.example.bloder.rxmvp.base_arch.state.StateProtocol
import com.example.bloder.rxmvp.home.ui.fragments.DessertFragment
import com.example.bloder.rxmvp.home.ui.fragments.FavoriteFoodFragment
import com.example.bloder.rxmvp.home.ui.fragments.FoodFragment

/**
 * Created by bloder on 23/05/17.
 */
sealed class MainFoodStateRepresenter(val ref: Fragment = Fragment(), val refObject: MainFoodStateRepresenter = MainFoodStateRepresenter.FoodFragmentObject) : StateProtocol.Representer {
    data class FoodFragmentId(val state: FoodFragment = FoodFragment(), val id: MainFoodStateRepresenter = FoodFragmentObject) : MainFoodStateRepresenter(state, id)
    data class DessertFragmentId(val state: DessertFragment = DessertFragment(), val id: MainFoodStateRepresenter = DessertFragmentObject) : MainFoodStateRepresenter(state, id)
    data class FavoriteFoodFragmentId(val state: FavoriteFoodFragment = FavoriteFoodFragment(), val id: MainFoodStateRepresenter = FavoriteFragmentObject) : MainFoodStateRepresenter(state, id)
    object FoodFragmentObject : MainFoodStateRepresenter()
    object DessertFragmentObject : MainFoodStateRepresenter()
    object FavoriteFragmentObject : MainFoodStateRepresenter()
}
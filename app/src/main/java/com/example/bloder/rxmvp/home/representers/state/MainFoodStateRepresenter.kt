package com.example.bloder.rxmvp.home.representers.state

import android.support.v4.app.Fragment
import com.example.bloder.rxmvp.base_arch.state.StateProtocol
import com.example.bloder.rxmvp.home.ui.fragments.DessertFragment
import com.example.bloder.rxmvp.home.ui.fragments.FavoriteFoodFragment
import com.example.bloder.rxmvp.home.ui.fragments.FoodFragment

/**
 * Created by bloder on 23/05/17.
 */
sealed class MainFoodStateRepresenter(val ref: Fragment = Fragment()) : StateProtocol.Representer {
    data class FoodFragmentId(val state: FoodFragment = FoodFragment()) : MainFoodStateRepresenter(state)
    data class DessertFragmentId(val state: DessertFragment = DessertFragment()) : MainFoodStateRepresenter(state)
    data class FavoriteFoodFragmentId(val state: FavoriteFoodFragment = FavoriteFoodFragment()) : MainFoodStateRepresenter(state)
}
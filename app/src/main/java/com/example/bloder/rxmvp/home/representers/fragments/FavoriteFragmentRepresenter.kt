package com.example.bloder.rxmvp.home.representers.fragments

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 27/05/17.
 */
sealed class FavoriteFragmentRepresenter : Cloud.Representer {
    data class AddFavorite(val food: Food = Food()) : FavoriteFragmentRepresenter()
}
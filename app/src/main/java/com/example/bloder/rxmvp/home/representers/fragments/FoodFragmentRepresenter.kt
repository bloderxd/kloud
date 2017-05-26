package com.example.bloder.rxmvp.home.representers.fragments

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 23/05/17.
 */
sealed class FoodFragmentRepresenter : Cloud.Representer {

    data class FoodFetched(var foods: List<Food> = listOf()) : FoodFragmentRepresenter()
}
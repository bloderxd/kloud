package com.example.bloder.rxmvp.home.representers

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 20/05/17.
 */
sealed class FoodPresenterRepresenter : Cloud.Representer {

    data class FoodFetched(val foods: List<Food> = listOf()) : FoodPresenterRepresenter()
    object FetchFood : FoodPresenterRepresenter()
}
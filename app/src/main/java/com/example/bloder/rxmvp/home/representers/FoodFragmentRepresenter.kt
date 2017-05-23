package com.example.bloder.rxmvp.home.representers

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.identifiers.fragments.FoodChildViewId
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 23/05/17.
 */
class FoodFragmentRepresenter(val id: FoodChildViewId) : Cloud.Representer {

    var foods: List<Food> = listOf()

    constructor(id: FoodChildViewId, foods: List<Food>) : this(id) {
        this.foods = foods
    }
}
package com.example.bloder.rxmvp.home.representers

import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.identifiers.FoodId
import com.example.bloder.rxmvp.rx.Cloud

/**
 * Created by bloder on 20/05/17.
 */
data class FoodRepresenter(val id: FoodId) : Cloud.Representer {

    var foods: List<Food> = listOf()

    constructor(id: FoodId, foods: List<Food>) : this(id) {
        this.foods = foods
    }
}
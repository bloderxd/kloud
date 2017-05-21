package com.example.bloder.rxmvp.home.arch

import com.example.bloder.rxmvp.data.Food

/**
 * Created by bloder on 20/05/17.
 */
class FoodInteractor : FoodContract.Interactor {

    override fun fetchFood(): Food = Food()
}
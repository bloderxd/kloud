package com.example.bloder.rxmvp

import android.support.multidex.MultiDexApplication
import com.example.bloder.rxmvp.rx.RxFood

/**
 * Created by bloder on 21/05/17.
 */
class FoodApplication : MultiDexApplication() {

    val rxFood : RxFood = RxFood()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private var instance: FoodApplication? = null

        fun provide() : FoodApplication = instance?:FoodApplication()
    }
}
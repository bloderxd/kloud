package com.example.bloder.rxmvp.home.ui.fragments

import com.example.bloder.rxmvp.base_arch.mvp.RxBasePresenter
import com.example.bloder.rxmvp.data.Food
import com.example.bloder.rxmvp.home.arch.FoodContract
import com.example.bloder.rxmvp.home.representers.FoodPresenterRepresenter
import com.example.bloder.rxmvp.home.representers.fragments.FoodFragmentRepresenter
import com.example.bloder.rxmvp.home.representers.state.MainFoodStateRepresenter

/**
 * Created by bloder on 22/05/17.
 */
class FoodFragment : BaseMainFragment(), FoodContract.FoodView {

    override val presenter: RxBasePresenter<*>? = null
    override var cloud by cloud()
    private val foods: MutableList<Food> = mutableListOf()

    override fun onFoodFetched(foods: List<Food>) {
        this.foods.addAll(foods)
    }

    override fun work() {
        registerReceiver()
        askForFoods()
    }

    private fun askForFoods() {
        cloud.post(FoodPresenterRepresenter.FetchFood)
    }

    override fun onReceive(event: FoodFragmentRepresenter) {
        when(event) {
            is FoodFragmentRepresenter.FoodFetched -> run { onFoodFetched(event.foods) }
        }
    }

    override fun getRepresenter(): Class<FoodFragmentRepresenter> = FoodFragmentRepresenter::class.java
    override fun getStateRepresenter(): MainFoodStateRepresenter.FoodFragmentId = MainFoodStateRepresenter.FoodFragmentId(this)
    override fun shouldWork(): Boolean = foods.size == 0
}